package in.shivam.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlReportDaoImpl implements ReportDao{
	public MySqlReportDaoImpl() {
		System.out.println("MySqlReportDaoImpl :: Constructor");
	}
	
	@Override
	public String findData() {
		System.out.println("fetching report from MySql db");
		return "Report Data";
	}
}
