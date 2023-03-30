package in.shivam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import in.shivam.dao.ReportDao;

@Service
public class ReportService {
	private ReportDao reportDao;
		
	/* @Autowired
	public void setReportDao(ReportDao reportDao) {
		System.out.println("setReportDao() :: Method Called");
		this.reportDao=reportDao;
	} */
	
	@Autowired
	public ReportService(ReportDao reportDao) {
		System.out.println("ReportService :: Param Constructor Called");
		this.reportDao=reportDao;
	}
	
	public void generateReport() {
		reportDao.findData();
		System.out.println("Generating Report...");
	}
}
