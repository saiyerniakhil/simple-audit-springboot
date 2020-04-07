package com.akhil.sampleaudit;

public interface IBarService {
	public void addBar(Bar bar);
	public void updateBar(Integer id, String name);
	public void deleteBar(Integer id);
}
