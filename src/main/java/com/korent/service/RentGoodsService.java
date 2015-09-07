package com.korent.service;

import com.google.gson.*;
import com.korent.dao.NotificationDao;
import com.korent.dao.RentGoodsDao;
import com.korent.dao.UserDao;
import com.korent.entity.RentGoods;
import com.korent.util.RentGoodsExclusionStrategy;
import com.korent.util.RentGson;
import com.korent.util.UserGson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lei on 15-8-28.
 */
public class RentGoodsService {

    private UserDao userDao;
    private NotificationDao notificationDao;
    private RentGoodsDao rentGoodsDao;
    public RentGoodsService() {
    }


    /*根据id获取租品的信息*/
    public RentGoods getRentGoodsInfo(Serializable id) {
      return rentGoodsDao.get(RentGoods.class, id);

    }

    /*分页获取租品信息*/
    public List<RentGoods> getRentGoodsByPage(int pageNo, int pageSize){

        return   rentGoodsDao.getRentGoodsByPage(pageNo, pageSize);

    }

      /*获取所有租品*/
    public List<RentGoods> getAllRentGoods(){
        return rentGoodsDao.findAll(RentGoods.class);
    }

    /*获取租品分页的总数*/
    public Integer getRentGoodsPage(int pageSize){
        List<RentGoods> list = getAllRentGoods();
        return list.size() % pageSize == 0 ? list.size() / pageSize : list.size() /pageSize + 1;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public NotificationDao getNotificationDao() {
        return notificationDao;
    }

    public void setNotificationDao(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    public RentGoodsDao getRentGoodsDao() {
        return rentGoodsDao;
    }

    public void setRentGoodsDao(RentGoodsDao rentGoodsDao) {
        this.rentGoodsDao = rentGoodsDao;
    }


}
