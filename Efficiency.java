package com.example.demo.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import com.example.demo.model.ExcelData;
import com.poiji.bind.Poiji;

public class Efficiency {

	public static void main(String[] args) {
		File file = new File("src/main/resources/Hackathon Timesheet.xlsx");
		List<ExcelData> data = Poiji.fromExcel(file, ExcelData.class);
		TreeSet<String> treeset=new TreeSet<String>();
		data.forEach( d -> treeset.add(d.getOwner()));
		Iterator itr=treeset.iterator();
		TreeMap<Double,String> map=new TreeMap<Double,String>();
		
		while(itr.hasNext()) {
			String owner=String.valueOf(itr.next());
		double effort=data.stream().filter(e -> e.getOwner().equalsIgnoreCase(owner))
		.mapToDouble( d -> d.getHours()).sum();
		map.put((80/effort)*100,owner);
		}
		int count=0;
		System.out.println("------5 Employees with the lowest efficiency-----------");
		for(Map.Entry<Double,String> m : map.entrySet()) {
			if(count<=5)
				System.out.println("Efficiency of "+m.getValue()+" is "+m.getKey());
				
				count++;
		}

	}

}
