package com.geminno.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {
	public MyTextView(Context context) {
		super(context);
		
	}
	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}
	private int sroke_width = 1; 
	@Override  
    protected void onDraw(Canvas canvas) {  
        Paint paint = new Paint();  
        //  灏嗚竟妗嗚涓洪粦鑹� 
        paint.setColor(android.graphics.Color.BLACK);  
        paint.setStyle(Paint.Style.STROKE);
        //  鐢籘extView鐨�涓竟  
        canvas.drawLine(0, 0, this.getWidth() - sroke_width, 0, paint);  
        canvas.drawLine(0, 0, 0, this.getHeight() - sroke_width, paint); 
        canvas.drawLine(this.getWidth() - sroke_width, 0, this.getWidth() - sroke_width, this.getHeight() - sroke_width, paint);  
        canvas.drawLine(0, this.getHeight() - sroke_width, this.getWidth() - sroke_width, this.getHeight() - sroke_width, paint);
        super.onDraw(canvas);  
    }  

}
