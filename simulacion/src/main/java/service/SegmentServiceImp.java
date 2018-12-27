package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import clases.Segment;
import segment.dao.DaoSegmentItem;

@Service
public class SegmentServiceImp implements SegmentService{
	
	@Autowired
	private DaoSegmentItem segmentDao;

	@Transactional
	@Override
	public boolean add(Segment segment) {
		return segmentDao.add(segment);
	}

}
