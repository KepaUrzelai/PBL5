package segment.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clases.Segment;

@Repository
public class DaoSegmentItemMySQL implements DaoSegmentItem{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Segment segment) {
		sessionFactory.getCurrentSession().save(segment);
	    return true;
	}

	
}
