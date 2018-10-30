package com.company.assesment5.service;

import com.company.assesment5.dao.ExceptionClassNotFound;
import com.company.assesment5.dao.InventoryOperationsDAO;
import com.company.assesment5.dao.InventoryOperationsDAOImpl;
import com.company.assesment5.dto.InventoryItemDTO;
import org.apache.log4j.Logger;
import java.util.List;

public class InventoryOperationsServiceImpl implements InventoryOperationsService {


    final static Logger logger = Logger.getLogger(InventoryOperationsServiceImpl.class);

    InventoryOperationsDAO dao;

    public InventoryOperationsDAO getDao() {
        if (dao==null){
            return new InventoryOperationsDAOImpl();
        }
        return dao;
    }

    public void setDao(InventoryOperationsDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<InventoryItemDTO> getItemDetails() {

        List<InventoryItemDTO> itemList = null;

        try {
            itemList = getDao().getItemList();
        } catch (ExceptionClassNotFound e) {

            logger.error(e);
        }


        return itemList;
    }
}
