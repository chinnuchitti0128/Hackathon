package com.example.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import com.example.demo.model.ExcelData;
import com.poiji.bind.Poiji;

public class MeanEffort {

	public static void main(String args[]) {

		File file = new File("src/main/resources/Hackathon Timesheet.xlsx");
		List<ExcelData> data = Poiji.fromExcel(file, ExcelData.class);
		List<ExcelData> designEffort = new ArrayList<ExcelData>();
		List<ExcelData> devEffort = new ArrayList<ExcelData>();
		List<ExcelData> pmEffort = new ArrayList<ExcelData>();
		List<ExcelData> qaEffort = new ArrayList<ExcelData>();

		TreeSet<String> projectNameSet = new TreeSet<String>();
		data.forEach(d -> projectNameSet.add(d.getProjectName()));

		data.forEach(e -> {
			if (e.getTeam().equalsIgnoreCase("Design")) {
				designEffort.add(e);
			}
			if (e.getTeam().equalsIgnoreCase("Dev")) {
				devEffort.add(e);
			}
			if (e.getTeam().equalsIgnoreCase("PM")) {
				pmEffort.add(e);
			}
			if (e.getTeam().equalsIgnoreCase("QA")) {
				qaEffort.add(e);
			}

		});
		Iterator i = projectNameSet.iterator();
		while (i.hasNext()) {
			String name = String.valueOf(i.next());
			System.out.println("----Various Teams  Mean Effort spent on Project " + name + "------");
			double sum = designEffort.stream().filter(e -> e.getProjectName().equalsIgnoreCase(name))
					.mapToDouble(d -> d.getHours()).sum();
			long count = designEffort.stream().filter(e -> e.getProjectName().equalsIgnoreCase(name)).count();
			if (count != 0)
				System.out.println("Mean Effort spent by Design team on project '" + name + "' is " + sum / count);

			double sumDev = devEffort.stream().filter(e -> e.getProjectName().equalsIgnoreCase(name))
					.mapToDouble(d -> d.getHours()).sum();
			long countDev = devEffort.stream().filter(e -> e.getProjectName().equalsIgnoreCase(name)).count();
			if (countDev != 0)
				System.out.println("Mean Effort spent by Dev team on project '" + name + "' is " + sumDev / countDev);

			double sumPM = pmEffort.stream().filter(e -> e.getProjectName().equalsIgnoreCase(name))
					.mapToDouble(d -> d.getHours()).sum();
			long countPM = pmEffort.stream().filter(e -> e.getProjectName().equalsIgnoreCase(name)).count();
			if (countPM != 0)
				System.out.println("Mean Effort spent by PM team on project '" + name + "' is " + sumPM / countPM);

			double QaSum = qaEffort.stream().filter(e -> e.getProjectName().equalsIgnoreCase(name))
					.mapToDouble(d -> d.getHours()).sum();
			long QaCount = qaEffort.stream().filter(e -> e.getProjectName().equalsIgnoreCase(name)).count();
			if (QaCount != 0)
				System.out.println("Mean Effort spent by QA team on project '" + name + "' is " + (QaSum / QaCount));
			System.out.println("---------------------------------------------");
		}

	}
}
