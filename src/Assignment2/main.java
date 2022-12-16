package Assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class main {

	public static void main(String args[]) throws InvalidTotalException{

		        Transcript t = new Transcript("input.txt", "");
		        ArrayList<Student> s = t.buildStudentArray();
		        t.printTranscript(s);
		
	}
}
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
//		ArrayList<Integer> weight = new ArrayList<Integer>();
//		ArrayList<Double> finalGrade = new ArrayList<Double>();
//		ArrayList<Double> grade = new ArrayList<Double>();
//		weight.add(10);
//		weight.add(35);
//		weight.add(40);
//		weight.add(20);
//		
//		grade.add(50.0);
//		grade.add(65.0);
//		grade.add(70.0);
//		grade.add(80.0);
//		
//		double true_Grade = 0.0;
//		double total_Grade = 0.0;
//		int weight_Size = 0;
//		for(int i = 0; i < weight.size(); i++) {
//			true_Grade = Math.round(((weight.get(i)*grade.get(i)/100.0)*10.0))/10.0;
//			total_Grade += true_Grade;
//			weight_Size += weight.get(i);
//			finalGrade.add(i, total_Grade);
//		} 
//		for(int i =0; i<finalGrade.size(); i++)
//			System.out.println(finalGrade.get(i));
//		ArrayList<String> str = new ArrayList<String>();
//		ArrayList<String[]> st = new ArrayList<String[]>();
//
//		str.add("Ur,mad,bro");
//		str.add("No,ur,mad");
//		str.add("NO,you");
//		str.add("We,all,mad");
//		str.add("splitted,forsure,right?");
//		
//		for(String s : str) {
//			String[] c = s.split(",");
//			st.add(c);
//		}
//		for(int i = 0; i < st.size(); i++) {
//			System.out.println(st.get(i)[1]);
//		}

		        
		        
//		 Scanner input = new Scanner(new File("input.txt")); 
//		 while (input.hasNext()) {
//			 System.out.println(input.next());
//		 }
//		 Assessment.getInstance('E', 40);
//		 ArrayList<Course> courseList = new ArrayList<Course>();
//		 ArrayList<Course> courseList2 = new ArrayList<Course>();
//		 ArrayList<Course> courseList3 = new ArrayList<Course>();
//
//		 ArrayList<Assessment> assessList = new ArrayList<Assessment>();
//		 ArrayList<Assessment> assessList2 = new ArrayList<Assessment>();
//		 ArrayList<Assessment> assessList3 = new ArrayList<Assessment>();
//		 
//		 ArrayList<Double> finalGrade = new ArrayList<Double>();
//         ArrayList<Integer> weight = new ArrayList<Integer>();
//
//		 
//		 ArrayList<Student> s = new ArrayList<Student>();
////		
//		;
//		 		 
//		Course c1 = new Course("EECS2030",assessList, 3.0);
//		Course c2 = new Course("EECS2012",assessList2, 4.0);
//		Course c3 = new Course("EECS2030",assessList3, 3.0);
//		
//		courseList.add(c1);
//		courseList.add(c2);
//		courseList.add(c3);
//		
//		courseList2.add(c1);
//		courseList2.add(c2);
//		courseList2.add(c3);
//		
//		courseList3.add(c1);
//		courseList3.add(c2);
//		courseList3.add(c3);
//		
//		Student stu = new Student("1000","Dinuj", courseList);
//		Student stu2 = new Student("2000","Ammar", courseList2);
//		Student stu3 = new Student("3000","Matt", courseList3);
//		
//		
//		
//		finalGrade.add(66.6);
//		finalGrade.add(64.5);
//		finalGrade.add(70.2);
//		finalGrade.add(85.9);
//		
//		weight.add(10);
//		weight.add(35);
//		weight.add(40);
//		weight.add(20);
//		
//		stu.addGrade(finalGrade, weight);
//		stu2.addGrade(finalGrade, weight);
//		stu3.addGrade(finalGrade, weight);
//
//		s.add(stu);
//		s.add(stu2);
//		s.add(stu3);
//		
//		printTranscript(s);
//	}
//	
//	public static void printTranscript(ArrayList<Student> s) {
//		for(Student student : s) {
//			System.out.println(student.getName()+"\t"+ student.getStudentID());
//			System.out.println("--------------------");
//			for(int i = 0; i < student.getCourseTaken().size(); i++) {
//				System.out.println(student.getCourseTaken().get(i).getCode()+"\t"+student.getFinalGrade().get(i));
//				System.out.println("GPA: "+student.weightedGPA());
//			}
//		}
	
		
		
//		 double true_grade = 0;
//		true_grade = Math.round(27*33)/100.0;
//		System.out.println(true_grade);
//		ArrayList<Double> finalGrade = new ArrayList<Double>();
//		ArrayList<Integer> weight = new ArrayList<Integer>();

//		ArrayList<Course> courseTaken = new ArrayList<Course>();
//		ArrayList<Assessment> a1 = new ArrayList<Assessment>();
//		ArrayList<Assessment> a2 = new ArrayList<Assessment>();
//		ArrayList<Assessment> a3 = new ArrayList<Assessment>();
//		ArrayList<Assessment> a4 = new ArrayList<Assessment>();
//		ArrayList<Assessment> a5 = new ArrayList<Assessment>();
//		ArrayList<Assessment> a6 = new ArrayList<Assessment>();
//		ArrayList<Assessment> a7 = new ArrayList<Assessment>();
//		ArrayList<Assessment> a8 = new ArrayList<Assessment>();

//		Course c4 = new Course("EECS2030",a4, 3.0);
//		Course c5 = new Course("EECS2030",a5, 3.0);
//		Course c6 = new Course("EECS2030",a6, 3.0);
//		Course c7 = new Course("EECS2030",a7, 3.0);
//		Course c8 = new Course("EECS2030",a8, 3.0);

//		finalGrade.add(66.6);
//		finalGrade.add(64.5);
//		finalGrade.add(70.2);
//		finalGrade.add(85.9);
//		weight.add(10);
//		weight.add(35);
//		weight.add(40);
//		weight.add(20);
//		courseTaken.add(c3);
//		finalGrade.add(64.12);
//		courseTaken.add(c4);
//		finalGrade.add(69.33);
//		courseTaken.add(c5);
//		finalGrade.add(70.78);
//		courseTaken.add(c6);
//		finalGrade.add(75.89);
//		courseTaken.add(c7);
//		finalGrade.add(80.96);
//		courseTaken.add(c8);
//		finalGrade.add(90.14);
//		addGrade(finalGrade, weight);
		
		
	//	public static void addGrade(ArrayList<Double> grade, ArrayList<Integer> weight) throws InvalidTotalException {	
//		ArrayList<Double> finalGrade = new ArrayList<Double>();
//		double true_grade = 0;
//		int weight_size = 0;
//		for(int i = 0; i < weight.size(); i++) {
//			true_grade = Math.round(((weight.get(i)*grade.get(i)/100.0)*10.0))/10.0;
//			weight_size += weight.get(i);
//			finalGrade.add(i, true_grade);
//		} 
//		try {
//			if(weight_size!=100)throw new InvalidTotalException("The total weight is not 100, YOUR MAD!");
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}	
//	}

	
	
//	public static double GPA(ArrayList<Double> finalGrade, ArrayList<Course> courseTaken  ) {
//		double gpa = 0.0;
//		double credit_count = 0;
//		for(int i =0; i < finalGrade.size(); i++) {
//			if(90.00<=finalGrade.get(i)&&finalGrade.get(i)<=100.00){
//				gpa += 9.0* (courseTaken.get(i).getCredit()); 
//				credit_count += courseTaken.get(i).getCredit();
//			}
//			else if(80.00<=finalGrade.get(i)&&finalGrade.get(i)<=89.99){
//				gpa += 8.0* (courseTaken.get(i).getCredit());
//				credit_count += courseTaken.get(i).getCredit();
//			}
//			else if(75.00<=finalGrade.get(i)&&finalGrade.get(i)<=79.99){
//				gpa += 7.0*(courseTaken.get(i).getCredit());
//				credit_count += courseTaken.get(i).getCredit();
//			}
//			else if(70.00<=finalGrade.get(i)&&finalGrade.get(i)<=74.99){
//				gpa += 6.0* (courseTaken.get(i).getCredit());
//				credit_count += courseTaken.get(i).getCredit();
//			}
//			else if(65.00<=finalGrade.get(i)&&finalGrade.get(i)<=69.99){
//				gpa += 5.0* (courseTaken.get(i).getCredit());
//				credit_count += courseTaken.get(i).getCredit();
//			}
//			else if(60.00<=finalGrade.get(i)&&finalGrade.get(i)<=64.99){
//				gpa += 4.0* (courseTaken.get(i).getCredit());
//				credit_count += courseTaken.get(i).getCredit();
//			}
//			else if(55.00<=finalGrade.get(i)&&finalGrade.get(i)<=59.99){
//				gpa += 3.0* (courseTaken.get(i).getCredit());
//				credit_count += courseTaken.get(i).getCredit();
//			}
//			else if(50.00<=finalGrade.get(i)&&finalGrade.get(i)<=54.99){
//				gpa += 2.0* (courseTaken.get(i).getCredit());
//				credit_count += courseTaken.get(i).getCredit();
//			}
//			else if(47.00<=finalGrade.get(i)&&finalGrade.get(i)<=49.99){
//				gpa += 1.0* (courseTaken.get(i).getCredit());
//				credit_count += courseTaken.get(i).getCredit();
//			}
//		}
//		return Math.round((gpa/credit_count)*10.0)/10.0;
//	}

//			for(int i  = 0; i<finalGrade.size(); i++) {
//				if(90.00<=finalGrade.get(i)||finalGrade.get(i)<=100){
//					gpa += 9.0;
//				}
//				else if(80.00<=finalGrade.get(i)||finalGrade.get(i)<=89.99){
//					gpa += 8.0 ;
//				}
//				else if(75.00<=finalGrade.get(i)||finalGrade.get(i)<=79.99){
//					gpa += 7.0 ;
//				}
//				else if(70.00<=finalGrade.get(i)||finalGrade.get(i)<=74.99){
//					gpa += 6.0 ;
//				}
//				else if(65.00<=finalGrade.get(i)||finalGrade.get(i)<=69.99){
//					gpa += 5.0 ;
//				}
//				else if(60.00<=finalGrade.get(i)||finalGrade.get(i)<=64.99){
//					gpa += 4.0 ;
//				}
//				else if(55.00<=finalGrade.get(i)||finalGrade.get(i)<=59.99){
//					gpa += 3.0 ;
//				}
//				else if(50.00<=finalGrade.get(i)||finalGrade.get(i)<=54.99){
//					gpa += 2.0;
//				}
//				else if(47.00<=finalGrade.get(i)||finalGrade.get(i)<=49.99){
//					gpa += 1.0 ;
//				}	
//			}
//			return gpa;