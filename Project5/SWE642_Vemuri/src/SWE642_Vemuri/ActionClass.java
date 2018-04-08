//Krishna Sindhuri Vemuri- G01024066


package SWE642_Vemuri;


import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import SWE642_Vemuri.DataBean;
import SWE642_Vemuri.DataProcessor;
import SWE642_Vemuri.StudentBean;
import SWE642_Vemuri.StudentDAO;

public class ActionClass extends ActionSupport implements
ModelDriven<StudentBean> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentBean sb=new StudentBean();
	private DataBean stm=new DataBean();
	private String id;
	private StudentBean sbretrieve=new StudentBean();
	private String[] idList;
	
	public StudentBean getModel() {
		// TODO Auto-generated method stub
		return sb;
	}
	
	public void setStudentBean(StudentBean sb) {
		this.sb = sb;
	}

	public StudentBean getStudentBean() {
		return sb;
	}	
	public DataBean getStm() {
		return stm;
	}

	public void setStm(DataBean stm) {
		this.stm = stm;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMethod(){ 
		
		StudentDAO sbretrieve1 =new StudentDAO();
		sbretrieve=sbretrieve1.getDO(id);
		//this.setStudentBean(sbretrieve);
		return "student_info";
	}
	
	
 public StudentBean getStudentDataRetrieve() {
		return sbretrieve;
	}

	public void setStudentDataRetrieve(StudentBean sbretrieve) {
		this.sbretrieve = sbretrieve;
	}

public String[] getIdList() {
		return idList;
	}

	public void setIdList(String[] idList) {
		this.idList = idList;
	}

public String execute(){
	StudentDAO studentmodel= new StudentDAO();
	 DataProcessor dataprocess =new DataProcessor();
	double sd;
	float mean;
	
	 
	 try {
		studentmodel.saveForm(sb);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 mean=dataprocess.Mean_Method(sb.getData());
	 sd=dataprocess.Standard_Deviation_Method(sb.getData(), mean);
	 stm.setMean(mean);
	 stm.setStandardDeviation(sd);
	 idList = studentmodel.Ids().split(","); 
	 
	 if (mean>90)
	 {
		 return "winner_ack";
	 }
	 else
	 {
		 return "simple_ack";
	 }
	 

	 
 }

}


