package com.example.demo.model;

import javax.persistence.Entity;

import com.poiji.annotation.ExcelCellName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor

public class ExcelData {
	

	public ExcelData(){
		
	}
	@ExcelCellName("Date") 
	private String date;
	
	@ExcelCellName("Project Name")
	private String projectName;
	
	@ExcelCellName("Hours")
	private double hours;
	
	@ExcelCellName("Owner")
	private String owner;
	
	@ExcelCellName("Team") 
	private String team;
	
	@ExcelCellName("Billing Status")
	private String billingStatus;
	
	@Override
	public String toString() {
		return "InvoiceExcel Date=" + date + ", Project Name=" + projectName + ", Hours=" + hours
				+ ", owner=" + owner + "]";
	}
}
