package com.leetcode.www;

public class BermudaTriangle {
	public static void main(String[] args){
		//get the 3 coordinates and the boat and plane coordinates
	}
	
	public boolean isInsideTriangle(int px, int py, int x1,int y1,int x2,int y2,int x3,int y3)
	{
		//find the area of the outer triangle
		float fullArea = (float) (0.5*((x2-x1)*(y3-y1) - (x3-x1)*(y2-y1)));
		//calc the inner sub triangle areas
		//
		float area1 = (float) (0.5*((px-x1)*(y3-y1) - (x3-x1)*(py-y1)));
		float area2 = (float) (0.5*((x2-x1)*(py-y1) - (px-x1)*(y2-y1)));
		float area3 = (float) (0.5*((x2-px)*(y3-py) - (x3-px)*(y2-py)));
		if(Math.abs(fullArea - (area1+area2+area3)) <= 0.5)
		{
			//inside
			return true;
		}
		else
			return false;
	}

}
