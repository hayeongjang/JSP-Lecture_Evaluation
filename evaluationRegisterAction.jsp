<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="evaluation.EvaluationDTO"%>
<%@ page import="evaluation.EvaluationDAO"%>
<%@ page import="util.SHA256"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userID = "";
	if(session.getAttribute("userID") != "") {
		userID = (String) session.getAttribute("userID");
	}
	if(userID == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요.');");
		script.println("location.href = 'userLogin.jsp';");
		script.println("</script>");
		script.close();
		return;
	}
	
	
	String lectureName = null;
	String professorName = null;
	int lectureYear = 0;
	String semesterDivide = null;
	String lectureDivide = null;
	String evaluationTitle = null;
	String evaluationContent = null;
	String totalScore = null;
	String creditScore = null;
	String comfortableScore = null;
	String letureScore = null;

	
	if(request.getParameter("lectureName") != null) {
		lectureName = (String) request.getParameter("lectureName");
	}
	if(request.getParameter("professorName") != null) {
		professorName = (String) request.getParameter("professorName");
	}
	if(request.getParameter("lectureYear") != null) {
		try {
			lectureYear = Integer.parseInt(request.getParameter("lectureYear"));
		} catch (Exception e) {
			System.out.println("강의 연도 데이터 오류");
		}
	}
	if(request.getParameter("semesterDivide") != null) {
		semesterDivide = (String) request.getParameter("semesterDivide");
	}
	if(request.getParameter("lectureDivide") != null) {
		lectureDivide = (String) request.getParameter("lectureDivide");
	}
	if(request.getParameter("evaluationTitle") != null) {
		evaluationTitle = (String) request.getParameter("evaluationTitle");
	}
	if(request.getParameter("evaluationContent") != null) {
		evaluationContent = (String) request.getParameter("evaluationContent");
	}
	if(request.getParameter("totalScore") != null) {
		totalScore = (String) request.getParameter("totalScore");
	}
	if(request.getParameter("creditScore") != null) {
		creditScore = request.getParameter("creditScore");
	}
	if(request.getParameter("comfortableScore") != null) {
		comfortableScore = (String) request.getParameter("comfortableScore");
	}
	if(request.getParameter("letureScore") != null) {
		letureScore = (String) request.getParameter("letureScore");
	}
	if(lectureName == null || professorName == null || lectureYear == 0 || semesterDivide == null
		|| lectureDivide == null || evaluationTitle == null || evaluationContent == null || totalScore == null
		|| creditScore == null || comfortableScore == null || letureScore == null ||
		evaluationTitle.equals("") || evaluationContent.equals("")) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
		
	}
	EvaluationDAO evaluationDAO = new EvaluationDAO();
	int result = evaluationDAO.write(new EvaluationDTO(0, userID, lectureName, professorName, lectureYear, semesterDivide,
			lectureDivide, evaluationTitle, evaluationContent, totalScore, creditScore, comfortableScore, letureScore, 0));
	if(result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('강의 평가 등록을 실패했습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	} else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'index.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
%>