package com.achila.ETLloadservice.service;

import com.achila.ETLloadservice.model.*;
import com.achila.ETLloadservice.repository.PEPDTO;
import com.achila.ETLloadservice.repository.TransactionDTO;
import com.achila.ETLloadservice.repository.WCLDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionDTO trans_dto;

    @Autowired
    private PEPDTO pepdto;

    @Autowired
    private WCLDTO wcldto;

    @Autowired
    private AlertSendService alertSendService;


    String line="";

    public void saveTransactionData(){

        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\JavaSW\\email-alert\\ETL-load-service\\transactions.csv"));
            while((line=br.readLine())!=null){
                String [] data =line.split(",");

                Transaction transaction = new Transaction();
                transaction.setClient_id(Integer.parseInt(data[0]));
                transaction.setOperation(data[1]);
                transaction.setAmount(Integer.parseInt(data[2]));
                transaction.setTrans_time(java.sql.Timestamp.valueOf(data[3]));
                trans_dto.save(transaction);

                //checking amount >15000

                if(transaction.getAmount()>=15000){

                    AlertList alertList = new AlertList();
                    List<AlertMessage> alerts = new ArrayList<AlertMessage>();
                    List<PEP>  peplist = (List<PEP>) pepdto.findAll();
                    for(PEP pep : peplist){
                        if(pep.getClient_id() == transaction.getClient_id()){
                            //match found
                            //create an alert
                            AlertMessage alertMessage =new AlertMessage(
                                    pep.getClient_id(),
                                    pep.getNationality(),
                                    pep.getDescription(),
                                    transaction.getOperation(),
                                    transaction.getAmount(),
                                    transaction.getTrans_time()
                            );
                            //adding to list of alerts

                            alerts.add(alertMessage);

                            //alertSendService.sendAlertMessage(alertMessage);
                            System.out.println("*******match found in pep*******"+pep.toString());
                            break;
                        }
                    }
                    List<WCL>  wcllist = (List<WCL>) wcldto.findAll();
                    for(WCL wcl : wcllist){
                        if(wcl.getClient_id() == transaction.getClient_id()){
                            //match found
                            //create an alert

                            AlertMessage alertMessage =new AlertMessage(
                                    wcl.getClient_id(),
                                    wcl.getNationality(),
                                    wcl.getDescription(),
                                    transaction.getOperation(),
                                    transaction.getAmount(),
                                    transaction.getTrans_time()
                            );
                            alerts.add(alertMessage);
                            //alertSendService.sendAlertMessage(alertMessage);
                            System.out.println("*******match found in wcl*******"+wcl.toString());
                            break;
                        }
                    }
                    //checking alert list is empty
                    if(alerts.isEmpty() == false){
                        System.out.println("Alerts found..........................................");
                        alertList.setAlertMessageList(alerts);
                        alertSendService.sendAlertMessage(alertList);
                    }
                }


            }
        }catch (IOException e){e.printStackTrace();}

    }

}
