package Assignment2;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
* This class generates a transcript for each student, whose information is in the text file.
*/

public class Transcript {
	private ArrayList<Object> grade = new ArrayList<Object>();
	private File inputFile;
	private String outputFile;

	public ArrayList<Object> getGrade() {
		return this.grade;
	}

	public void setGrade(ArrayList<Object> grade) {
		this.grade = grade;
	}

	public File getInputFile() {
		return this.inputFile;
	}

	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	public String getOutputFile() {
		return this.outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	/**
	 * This the the constructor for Transcript class that initializes its instance
	 * variables and call readFie private method to read the file and construct
	 * this.grade.
	 * 
	 * @param inFile  is the name of the input file.
	 * @param outFile is the name of the output file.
	 */
	public Transcript(String inFile, String outFile) {
		inputFile = new File(inFile);
		outputFile = outFile;
		grade = new ArrayList<Object>();
		this.readFile();
	}// end of Transcript constructor

	/**
	 * This method reads a text file and add each line as an entry of grade
	 * ArrayList.
	 * 
	 * @exception It throws FileNotFoundException if the file is not found.
	 */
	private void readFile() {
		Scanner sc = null;
		try {
			sc = new Scanner(inputFile);
			while (sc.hasNextLine()) {
				grade.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	} // end of readFile
	
	/**
	 * This the method used to construct a student array with student objects.
	 * This method will construct the array by creating several arrays for the 
	 * different properties of a student and then updating each array in a for-loop(s),
	 * We can then construct a student because the arrays are in parallel with each other.
	 * If a student student is located twice in the grade arrayList, we need to update that student by adding 
	 * the course at the i'th index of the grade arrayList and adding their grades and weights of the 
	 * assessments into their finalGrade arrayList.
	 *  
	 * @return a student array containing student objects.
	 * @throws InvalidTotalException
	 */
	public ArrayList<Student> buildStudentArray() throws InvalidTotalException {
		ArrayList<Student> student = new ArrayList<Student>(); 												// student array to store students
		ArrayList<String> info = new ArrayList<String>(); 													// stores the grade array as an string array in it
		ArrayList<String> courseID = new ArrayList<String>();												// courseID's array that stores the course ID's
		ArrayList<Double> credit = new ArrayList<Double>(); 												// course credits array that stores the credit of each course
		ArrayList<String> studentID_Checker = new ArrayList<String>(); 										// student ID checker array is used to check if a student appears more than once
		ArrayList<String> studentID = new ArrayList<String>(); 												// student ID's stores the student ID's 
		ArrayList<String> name = new ArrayList<String>(); // student names
		ArrayList<String> assess = new ArrayList<String>(); // stores all the ASSESSMENTS

		for (Object c : grade) { 																			// making all the info into a string type and storing it into info array
			String s1 = c.toString();
			info.add((s1.toString()));
		}
		for (String c : info) {									 											// storing names of the courses into an array
			String s1 = c.substring(0, 8);
			courseID.add((s1.toString()));
		}
		for (String c : info) { 																			// storing the credit of every course
			double s1 = Double.parseDouble(c.substring(9, 10));
			credit.add(s1);
		}
		for (String c : info) { 																			// storing the student ID
			String s1 = c.substring(11, 15);
			studentID.add((s1.toString()));
		}
		for (String c : info) { 																			// storing names of the students into an array
			String s1 = c.substring((c.lastIndexOf(",") + 1), c.length());
			name.add((s1.toString()));
		}
		for (String c : info) { 																			// storing practical assessments of the courses into an array
			String s1 = c.substring(c.indexOf("(", 9) - 3, c.lastIndexOf(","));
			assess.add((s1.toString()));
		}
		Assessment[] assessments = new Assessment[assess.size()]; 											// stores all assessment objects
		int counter = 0;
		for (int i = 0; i < assess.size(); i++) { 															// This for loop is to make the student objects
			if (studentID_Checker.contains(studentID.get(i))) { 											// If the student is already in the student ID checker asrrayList, then execute the following
				studentID_Checker.add(studentID.get(i));
				int l = 0; 																					// to find the index where the student was repeated
				counter++; 																					// to help index the student array for when a student is 
				for (int o = 0; o < studentID_Checker.size(); o++) {
					if (studentID_Checker.get(i).equals(studentID.get(o))) {								// checks at what index the student was first created in the student array
						l = o;																				// stores the index of where the student first appears, into l
						break;
					}
				}
				student.get(l).addCourse(new Course(courseID.get(i), new ArrayList<Assessment>(), credit.get(i)));
				String[] s2 = assess.get(i).split(",");
				ArrayList<Assessment> all_Assessments = new ArrayList<Assessment>();
				ArrayList<Double> grades = new ArrayList<Double>();
				ArrayList<Integer> weight = new ArrayList<Integer>();
				for (int j = 0; j < s2.length; j++) { 														// create all the assessment objects
					char type = s2[j].charAt(0);
					int Weight = Integer.parseInt(s2[j].substring(1, 3));
					double Grade = Double.parseDouble(s2[j].substring(4, s2[j].indexOf(")"))); 				// grade of the assessments
					all_Assessments.add(assessments[j] = Assessment.getInstance(type, Weight)); 			// creating assessments
					weight.add(Weight);																		// adding the weight to the Weight arrayList
					grades.add(Grade);																		// adding the grade of the assessment to the Grade arrayList
				}
				for (int j = 1; j < student.get(l).getCourseTaken().size(); j++) {							// adding all the assessments to the course
					student.get(l).getCourseTaken().get(j).setAssignment(all_Assessments);
				}
				student.get(l).addGrade(grades, weight);													// adding the grades into the student to get the final grades (calls the add grade method)
			} else { 																						// if the student is not in array execute the following code
				ArrayList<Assessment> all_Assessments = new ArrayList<Assessment>();
				ArrayList<Double> grades = new ArrayList<Double>();
				ArrayList<Course> coursesTaken = new ArrayList<Course>();
				ArrayList<Integer> weight = new ArrayList<Integer>();
				Course course = new Course(courseID.get(i), new ArrayList<Assessment>(), credit.get(i));
				String[] s2 = assess.get(i).split(","); 													// in the i'th index of the array (assess), create an array (s2) that stores an assessments in each index 					
				for (int j = 0; j < s2.length; j++) { 														// create all the assessment objects
					char type = s2[j].charAt(0);															// stores the type of the assessment
					int Weight = Integer.parseInt(s2[j].substring(1, 3));									// stores the weight of the assessment
					double Grade = Double.parseDouble(s2[j].substring(4, 6)); 								// store the grade of the assessment
					all_Assessments.add(assessments[j] = Assessment.getInstance(type, Weight)); 			// creates new instance of the assessment object and stores them in the array all_Assessments
					grades.add(Grade);																		// adding the weight to the Weight arrayList 
					weight.add(Weight);																		// adding the grade of the assessment to the Grade arrayList 	
				}
				course.setAssignment(all_Assessments);
				coursesTaken.add(course);
				student.add(new Student(studentID.get(i), name.get(i), coursesTaken));						
				student.get(i - counter).addGrade(grades, weight);
				studentID_Checker.add(studentID.get(i));													// adds the student's ID into my student ID checker arrayList
			}
		}
		return student;
	}
	
	/**
	 * This method prints the transcript of each student object in the s arrayList.		
	 * 
	 * @param s is an arrayList that contains student objects.
	 */
	public void printTranscript(ArrayList<Student> s) {
		outputFile = "";
		for (Student student : s) {
			outputFile += (student.getName() + "\t" + student.getStudentID() + "\n" + "--------------------" + "\n");
			for (int i = 0; i < student.getCourseTaken().size(); i++) {
				outputFile += (student.getCourseTaken().get(i).getCode() + "\t" + student.getFinalGrade().get(i)
						+ "\n");
			}
			outputFile += ("--------------------" + "\n" + "GPA: " + student.weightedGPA() + "\n" + "\n");
		}
		System.out.print(outputFile);
	}

} // end of Transcript

class Student {
	private String studentID;
	private String name;
	private ArrayList<Course> courseTaken = new ArrayList<Course>();
	private ArrayList<Double> finalGrade = new ArrayList<Double>();
	
	/**
	 * This is an empty, unused, Student constructor.
	 */
	public Student() {
	}
	
	/**
	 * This the the constructor for Student that initializes the student object.
	 * It creates a new instance of the ID and of the courses arrayList and
	 * stores these new, deep copied, instances in the student.
	 * 
	 * @param ID is the student's student ID.
	 * @param name is the student's name.
	 * @param Courses is a list of courses the student is taking.
	 */
	public Student(String ID, String name, ArrayList<Course> courses) {
		studentID = new String(ID);
		this.name = new String(name);
		setCourseTaken(courses);
	}
	
	/**
	 * This method takes the student's list of both the grades and weights of an assessment
	 * and get the overall grade of the course, and adds it into a list that stores the final grades.
	 * If the sum of the weight is not equal to 100% then it throw an InvalidTotalException.
	 * 
	 * @param grade is an arrayList that stores the grade of each assessment.
	 * @param weigjt is an arrayList that stores the weights of each assessment.
	 * @throws InvalidTotalException.
	 */
	public void addGrade(ArrayList<Double> grade, ArrayList<Integer> weight) throws InvalidTotalException {
		double true_Grade = 0.0;
		double total_Grade = 0.0;
		int weight_Size = 0;
		for (int i = 0; i < weight.size(); i++) {
			true_Grade = (weight.get(i)/100.0 * grade.get(i));
			total_Grade += true_Grade;
			weight_Size += weight.get(i);
		}
		finalGrade.add((Math.round(total_Grade * 10.0) / 10.0));
		try {
			if (weight_Size != 100)
				throw new InvalidTotalException("The total weight is not 100");
			if (total_Grade > 100.00)
				throw new InvalidTotalException("The total grade is greater than 100");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method computes the student's GPA. It takes the finalGrade arrayList and the 
	 * courseTaken arrayListm (getting the credit of each course and final grade) and calculates the 
	 * GPA by taking the sum of grade point*course credit / total credits.
	 * 
	 * @return the GPA of the student object.
	 */
	public double weightedGPA() {
		double gpa = 0.0;
		double credit_count = 0;
		for (int i = 0; i < finalGrade.size(); i++) {
			if (90 <= finalGrade.get(i) && finalGrade.get(i) <= 100.00) {
				gpa += 9.0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			} else if (80 <= finalGrade.get(i) && finalGrade.get(i) <= 89.99) {
				gpa += 8.0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			} else if (75 <= finalGrade.get(i) && finalGrade.get(i) <= 79.99) {
				gpa += 7.0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			} else if (70 <= finalGrade.get(i) && finalGrade.get(i) <= 74.99) {
				gpa += 6.0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			} else if (65 <= finalGrade.get(i) && finalGrade.get(i) <= 69.99) {
				gpa += 5.0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			} else if (60 <= finalGrade.get(i) && finalGrade.get(i) <= 64.99) {
				gpa += 4.0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			} else if (55 <= finalGrade.get(i) && finalGrade.get(i) <= 59.99) {
				gpa += 3.0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			} else if (50 <= finalGrade.get(i) && finalGrade.get(i) <= 54.99) {
				gpa += 2.0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			} else if (47 <= finalGrade.get(i) && finalGrade.get(i) <= 49.99) {
				gpa += 1.0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			} else {
				gpa += 0 * (courseTaken.get(i).getCredit());
				credit_count += courseTaken.get(i).getCredit();
			}
		}
		return Math.round((gpa / credit_count) * 10.0) / 10.0;
	}
	
	/**
	 * This method adds a course to the student's course arrayList.
	 * 
	 * @param c is the course the student takes. 
	 */
	public void addCourse(Course c) {
		courseTaken.add(c);
	}
	
	/**
	 * This method creates a new instance of the student's 
	 * ID and sets it as the student's ID.
	 * 
	 * @param studentID is the student's ID. 
	 */
	public void setStudentID(String studentID) {
		this.studentID = new String(studentID);
	}
	
	/**
	 * This method creates a new instance of the student's 
	 * name and sets it as the student's name.
	 * 
	 * @param name is the student's name. 
	 */
	public void setName(String name) {
		this.name = new String(name);
	}
	
	/**
	 * This method sets the student's courses taken arrayList.
	 * 
	 * @param course is an arrayList that contains course objects 
	 * (which are the courses the student has) . 
	 */
	public void setCourseTaken(ArrayList<Course> course) {
		for (int i =0; i<course.size();i++) {
			courseTaken.add(new Course(course.get(i).getCode(),course.get(i).getAssignment(),course.get(i).getCredit()));
		}
	}
	
	/**
	 * This method takes an arrayList that contains the final grades the student 
	 * got in each course and deep copies it. The deep copied array is now set as
	 * the student's final grades arrayList.
	 * 
	 * @param Grade is an arrayList that contains the final grades the student has
	 * for each course. 
	 */
	public void setFinalGrade(ArrayList<Double> Grade) {
		this.finalGrade = new ArrayList<Double>();
		for (int i = 0; i < Grade.size(); i++) {
			this.finalGrade.add(Grade.get(i));
		}
	}
	
	/**
	 * This method gets the student's ID. 
	 */
	public String getStudentID() {
		return this.studentID;
	}
	
	/**
	 * This method gets the student's name. 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method deep copies the students course taken array
	 * and returns the deep copied array.
	 * 
	 *  @return an arrayList that has deep copied the courseTaken arrayList. 
	 */
	public ArrayList<Course> getCourseTaken() {
		ArrayList<Course> co = new ArrayList<Course>();
		for (int i = 0; i < courseTaken.size(); i++) {
			co.add(new Course(courseTaken.get(i).getCode(),courseTaken.get(i).getAssignment(),courseTaken.get(i).getCredit()));
		}
		return co;
	}
	
	/**
	 * This method deep copies the students final grade array
	 * and returns the deep copied version.
	 *  
	 * @return an arrayList that has deep copied the finalGrade arrayList. 
	 */
	public ArrayList<Double> getFinalGrade() {
		ArrayList<Double> grades = new ArrayList<Double>();
		for (int i = 0; i < finalGrade.size(); i++) {
			grades.add(finalGrade.get(i));
		}
		return grades;
	}
}

class Course {
	private String code;
	private ArrayList<Assessment> assignment;
	private double credit;
	
	/**
	 * This is an empty, unused constructor.
	 */
	public Course() {}
	
	/**
	 * This is the constructor for Course that initializes the course object
	 * (it creates new instances of the course).
	 * 
	 * @param code is the course code.
	 * @param assignment is arrayList containing assessments for that course.
	 * @param credit is the credit of the course.
	 */
	public Course(String code, ArrayList<Assessment> assignment, double credit) {
		this.code = new String(code);
		setAssignment(assignment);
		this.credit = credit;
	}
	
	/**
	 * This is another constructor for Course which takes a course object
	 * and calls the main constructor with the parameters of the this course (code
	 * assignment arrayList and credit). 
	 * 
	 * @param c is a course object.
	 */
	public Course(Course c) {
		this(c.code, c.assignment, c.credit);
	}

	/**
	 * This method is the overridden equal method (of the object class).
	 * It checks if the objects share the same properties.
	 * If they have the same properties it will return true
	 * and false otherwise. 
	 * 
	 * @param an object of type Object.
	 * @return true if the objects are the same and false if they are not.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (assignment == null) {
			if (other.assignment != null)
				return false;
		} else if (!assignment.equals(other.assignment))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (Double.doubleToLongBits(credit) != Double.doubleToLongBits(other.credit))
			return false;
		return true;
	}
	
	/**
	 * This method creates a new instance of the parameter code
	 * and sets it to the course object's code.
	 * 
	 * @param code is the course code.
	 */
	public void setCode(String code) {
		this.code = new String(code);
	}

	/**
	 * This method assigns a new arrayList (of type Assessment) to the object's
	 * assignment array and then deep copies the param array (it deep copies the 
	 * assessment objects of the assign array and sets it into the object's
	 * assignment array)
	 * 
	 * @param assign is an assessment array that contains the types 
	 * of assessments.
	 */
	public void setAssignment(ArrayList<Assessment> assign) {
		this.assignment = new ArrayList<Assessment>(assign.size());
		for (Assessment assess : assign) {
			Assessment new_obj = Assessment.getInstance(assess.getType(), assess.getWeight());
			this.assignment.add(new_obj);
		}
	}

	/**
	 * This method takes a number(of type double) and set it as
	 * the course object's credit.
	 * 
	 * @param credit is the course credit.
	 */
	public void setCredit(double credit) {
		this.credit = credit;
	}

	/**
	 * This method returns the course object's code.
	 * 
	 * @return the course object's code.
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * This method creates a new arrayList that deep copies 
	 * the object's assignment arrayList ( specifically the arraList's
	 * assessment objects) and then it returns the new arrayList.
	 * 
	 * @return a deep copied assessment arrayList.
	 */
	public ArrayList<Assessment> getAssignment() {
		ArrayList<Assessment> assess = new ArrayList<Assessment>();
		for (Assessment as : assignment) {
			Assessment new_obj = Assessment.getInstance(as.getType(), as.getWeight());
			assess.add(new_obj);
		}
		return assess;
	}

	/**
	 * This method returns the course object's credit.
	 * 
	 * @return the course object's credit.
	 */
	public double getCredit() {
		return this.credit;
	}
}

class Assessment {
	private char type;
	private int weight;

	/**
	 * This is an empty (unused) constructor.
	 */
	public Assessment() {}

	/**
	 * This is the main constructor for Assessment objects.
	 * It will take parameters of the type of the assessment its weight
	 * and then assign them to the object.
	 * 
	 * @param is the type of the assessment.
	 * @param is the weight of the assessment.
	 */
	private Assessment(char type, int weight) {
		this.type = type;
		this.weight = weight;
	}

	/**
	 * This method is a static factory method that will create
	 * a new instance of the object and then calls the constructor to 
	 * set the properties of the object.
	 * 
	 * @param is the type of the assessment.
	 * @param is the weight of the assessment.
	 * @return a new instance of the assessment object.
	 */
	protected static Assessment getInstance(char type, int weight) {
		return new Assessment(type, weight);
	}
	
	/**
	 * This method is the overridden equal method (of the object class).
	 * It checks if the objects share the same properties.
	 * If they have the same properties it will return true
	 * and false otherwise. 
	 * 
	 * @param an object of type Object.
	 * @return true if the objects are the same and false if they are not.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assessment other = (Assessment) obj;
		if (type != other.type)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	/**
	 * This method takes a char and sets its as the object's type.
	 * 
	 * @param type is the type of the assessment.
	 */
	public void setType(char type) {
		this.type = type;
	}

	/**
	 * This method takes an integer and sets it as the object's weight.
	 * 
	 * @param weight is the weight of the assessment
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * This method returns the type of the assessment object.
	 * 
	 * @return the type of the assessment.
	 */
	public char getType() {
		return this.type;
	}

	/**
	 * This method returns the weight of the assessment.
	 * 
	 * @return the weight of the assessment.
	 */
	public int getWeight() {
		return this.weight;
	}
}

class InvalidTotalException extends Exception {
	/**
	 * This is the constructor that calls the super class's constructor to 
	 * instantiate the object.
	 */
	public InvalidTotalException() {
		super();
	}
	
	/**
	 * This is the constructor that takes a message (a string) and calls the super class's
	 * constructor with a string parameter (the message) to instantiate the object.
	 * 
	 * @param msg is a the string that is printed when the exception is created.
	 */
	public InvalidTotalException(String msg) {
		super(msg);
	}
}