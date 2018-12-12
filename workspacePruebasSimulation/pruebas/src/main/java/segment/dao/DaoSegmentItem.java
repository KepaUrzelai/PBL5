package segment.dao;

import clases.Segment;

public interface DaoSegmentItem {
	
	public Segment findSegmentByID();
	public boolean saveSegment(Segment segment);

}
