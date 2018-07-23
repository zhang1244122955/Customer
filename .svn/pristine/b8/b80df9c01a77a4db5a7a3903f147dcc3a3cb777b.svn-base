package com.zz624.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz624.biz.BroadcastBiz;
import com.zz624.dao.BroadcastDao;
import com.zz624.entry.Broadcast;
@Service
public class BroadcastBizImpl implements BroadcastBiz{
	
	@Autowired
	BroadcastDao broadcastDao;
	
	@Override
	public void modifyBroadcast(Broadcast broadcast) {

		broadcastDao.updateBroadcast(broadcast);
		
	}

	@Override
	public List<Broadcast> findBroadcast() {
		// TODO Auto-generated method stub
		return broadcastDao.selectBroadcast();
	}
	
}
