package segment.dao;

import clases.Segment;

public class SegmentItemFacade {

	DaoSegmentItem daoSegmentItem;
	
	public SegmentItemFacade() {
		daoSegmentItem = new DaoSegmentItemMySQL();
	}
	
	public boolean saveSegment(Segment segment){
		return daoSegmentItem.saveSegment(segment);
	}
}
