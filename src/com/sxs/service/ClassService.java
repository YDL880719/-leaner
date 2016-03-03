package com.sxs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sxs.mapping.ClassCaseObjectDAO;
import com.sxs.mapping.ClassExamObjectDAO;
import com.sxs.mapping.ClassObjectDAO;
import com.sxs.mapping.CommentObjectDAO;
import com.sxs.mapping.ContentObjectDAO;
import com.sxs.mapping.ExerciseObjectDAO;

public class ClassService {

	public static String getExerciseObjectDAOByClass(int classId, long userId) {
		JSONObject jo = new JSONObject();
		List list = ExerciseObjectDAO.getExerciseObjectDAOByClass(classId,
				userId);
		jo.put("exercise", list);
		return jo.toJSONString();

	}

	public static String updateExerciseById_stu(int exeId, long userId,
			String answer, int isCommit) {
		JSONObject jo = new JSONObject();
		int re = ExerciseObjectDAO.updateExerciseById_stu(exeId, userId,
				answer, isCommit);
		String code = "505";
		if (re > 0) {
			code = "200";
		}
		jo.put("code", code);
		return jo.toJSONString();
	}

	public static int selectExerciseById(int exeId, long userId) {
		JSONObject jo = new JSONObject();
		int re = ExerciseObjectDAO.selectExerciseById(exeId, userId);

		return re;

	}

	public static String insertExercise_stu(int exeId, long userId,
			String answer, int isCommit) {
		JSONObject jo = new JSONObject();
		int re = ExerciseObjectDAO.insertExercise_stu(exeId, userId, answer,
				isCommit);
		String code = "505";
		if (re > 0) {
			code = "200";
		}
		jo.put("code", code);
		return jo.toJSONString();

	}

	public static String getExerciseById(int exeId, long userId) {
		JSONObject jo = new JSONObject();
		List list = ExerciseObjectDAO.getExerciseById(exeId, userId);
		jo.put("exercise", list);
		return jo.toJSONString();

	}

	public static String getExamObjectDAOByClass(int classId, long userId) {
		JSONObject jo = new JSONObject();
		List list = ClassExamObjectDAO.getExamObjectDAOByClass(classId, userId);
		jo.put("classexam", list);
		return jo.toJSONString();

	}

	public static String getExamByexamId(int examId, long userId, int itemSort,
			int mark) {
		JSONObject jo = new JSONObject();
		List list = ClassExamObjectDAO.getExamByexamId(examId, userId,
				itemSort, mark);
		jo.put("exam", list);
		if (list.size() > 0) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			int itemId = (int) map.get("ItemId");
			List listanswer = ClassExamObjectDAO.getItemAnswerByItemId(itemId);
			jo.put("answer", listanswer);
		}
		return jo.toJSONString();

	}

	public static String getExamListByexamId(int examId, long userId) {
		JSONObject jo = new JSONObject();
		List<Map> listmap = new ArrayList<Map>();
		Map<String, Object> limap = new HashMap<String, Object>();
		List<Map> list = ClassExamObjectDAO.getExamListByexamId(examId, userId);

		if (list.size() > 0) {
			for (Map<String, Object> map : list) {
				int itemId = (int) map.get("ItemId");
				List listanswer = ClassExamObjectDAO
						.getItemAnswerByItemId(itemId);
				limap = new HashMap<String, Object>();
				limap.put("exam", map);
				limap.put("answer", listanswer);
				listmap.add(limap);
			}

		}
		jo.put("examlist", listmap);
		return jo.toJSONString();

	}

	public static int insertUserexamitem(int examId, int itemId, long userId,
			String answer, String commitTime) {
		JSONObject jo = new JSONObject();
		int re = ClassExamObjectDAO.insertUserexamitem(examId, itemId, userId,
				answer, commitTime);
		return re;

	}

	public static int updateUserexamitem(int examId, int itemId, long userId,
			String answer, String commitTime) {
		JSONObject jo = new JSONObject();
		int re = ClassExamObjectDAO.updateUserexamitem(examId, itemId, userId,
				answer, commitTime);
		return re;

	}

	public static int selectUserexamitem(int itemId, long userId) {
		List list = ClassExamObjectDAO.selectUserexamitem(itemId, userId);
		int re = 0;
		if (list.size() > 0) {
			re = 1;
		}
		return re;
	}

	public static int selectUserexam(int examId, long userId) {
		JSONObject jo = new JSONObject();
		List list = ClassExamObjectDAO.selectUserexam(examId, userId);
		int re = 0;
		if (list.size() > 0) {
			re = 1;
		}
		return re;
	}

	public static String insertUserexam(int examId, long userId, int examScore,
			String assessContent, int isAssess, int isCompleted) {
		JSONObject jo = new JSONObject();
		String code = "505";
		int re = ClassExamObjectDAO.insertUserexam(examId, userId, examScore,
				assessContent, isAssess, isCompleted);
		if (re > 0) {
			code = "200";
		}
		jo.put("code", code);
		return jo.toJSONString();
	}

	public static String updateUserexam(int examId, long userId, int examScore,
			String assessContent, int isAssess, int isCompleted) {
		JSONObject jo = new JSONObject();
		String code = "505";
		int re = ClassExamObjectDAO.updateUserexam(examId, userId, examScore,
				assessContent, isAssess, isCompleted);
		if (re > 0) {
			code = "200";
		}
		jo.put("code", code);
		return jo.toJSONString();

	}

	public static String getCommentListObjectDAOByClass(int classId, long userId) {
		JSONObject jo = new JSONObject();
		List list = CommentObjectDAO.getCommentListObjectDAOByClass(classId,
				userId);
		jo.put("commlist", list);
		return jo.toJSONString();

	}

	public static String insertComment(long userId, String commTime,
			String commContent, int classId) {
		JSONObject jo = new JSONObject();
		int re = CommentObjectDAO.insertComment(userId, commTime, commContent,
				classId);
		String code = "505";
		if (re > 0) {
			code = "200";
		}
		jo.put("code", code);
		return jo.toJSONString();

	}

	public static String getClassAllDataForUser(int schoolId, int userId) {
		JSONObject jo = new JSONObject();
		List list = ClassObjectDAO.getClassAllDataForUser(schoolId, userId);
		jo.put("classList", list);
		return jo.toJSONString();
	}

	public static String getClassAllDataForUserNotStart(int schoolId, int userId) {
		JSONObject jo = new JSONObject();
		List list = ClassObjectDAO.getClassAllDataForUserNotStart(schoolId,
				userId);
		jo.put("classList", list);
		return jo.toJSONString();
	}

	public static String getClassAllDataForUserCompleted(int schoolId,
			int userId) {
		JSONObject jo = new JSONObject();
		List list = ClassObjectDAO.getClassAllDataForUserCompleted(schoolId,
				userId);
		jo.put("classList", list);
		return jo.toJSONString();
	}

	public static String getClassAllDataForUserStart(int schoolId, int userId) {
		JSONObject jo = new JSONObject();
		List list = ClassObjectDAO
				.getClassAllDataForUserStart(schoolId, userId);
		jo.put("classList", list);
		return jo.toJSONString();
	}
}
