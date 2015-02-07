package com.jialin.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.astuetz.PagerSlidingTabStrip;

public class MessageInputToolBox extends RelativeLayout {
	
	private OnOperationListener onOperationListener;
	
	private Map<Integer, ArrayList<String>> faceData;
	private List<Option> functionData;
	
	/** input box **/
	private EditText messageEditText;
	private Button faceButton;
	private Button sendButton;
	private Button moreTypeButton;

	/** face box **/
	private RelativeLayout bottomHideLayout;
	private static RelativeLayout faceLayout;
	private ViewPager faceCategroyViewPager;
	private PagerSlidingTabStrip faceCategroyTabs;
	
	/** other function box **/
	private LinearLayout moreTypeLayout;
	private ViewPager fuctionViewPager;
	private LinearLayout pagePointLayout;
	List<View> functionGridViewList;
	List<ImageView> pointViews;
	
	//...
	
	FaceCategroyAdapter faceCategroyAdapter;
	
	private Context context;
	private FragmentManager fragmentManager;
	
	public MessageInputToolBox(Context context) {
		super(context);
		this.context = context;
		FragmentActivity fragmentActivity = (FragmentActivity) context;
		this.fragmentManager = fragmentActivity.getSupportFragmentManager();
		LayoutInflater.from(context).inflate(R.layout.message_input_tool_box, this);
	}
	
	public MessageInputToolBox(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		FragmentActivity fragmentActivity = (FragmentActivity) context;
		this.fragmentManager = fragmentActivity.getSupportFragmentManager();
		LayoutInflater.from(context).inflate(R.layout.message_input_tool_box, this);
		
		
	}

	public MessageInputToolBox(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		FragmentActivity fragmentActivity = (FragmentActivity) context;
		this.fragmentManager = fragmentActivity.getSupportFragmentManager();
		LayoutInflater.from(context).inflate(R.layout.message_input_tool_box, this);
	}
	
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		this.initView();
	}
	
	private void initView(){
			messageEditText 		= (EditText) findViewById(R.id.messageEditText);
			sendButton 				= (Button) findViewById(R.id.sendButton);
	
			bottomHideLayout		= (RelativeLayout) findViewById(R.id.bottomHideLayout);
			faceButton				= (Button) findViewById(R.id.faceButton);
			moreTypeButton			= (Button) findViewById(R.id.moreTypeButton);
			moreTypeLayout			= (LinearLayout) findViewById(R.id.moreTypeLayout);
			
			faceLayout				= (RelativeLayout) findViewById(R.id.faceLayout);
			faceCategroyViewPager 	= (ViewPager) findViewById(R.id.faceCategroyViewPager);
			faceCategroyTabs 		= (PagerSlidingTabStrip) findViewById(R.id.faceCategroyTabs);
			
			
			fuctionViewPager = (ViewPager) findViewById(R.id.fuctionViewPager);
			pagePointLayout = (LinearLayout) findViewById(R.id.pagePointLayout);

			fuctionViewPager.setOnPageChangeListener(new OnPageChangeListener() {
	
				@Override
				public void onPageSelected(int arg0) {
					for (int i = 0; i < pointViews.size(); i++) {
						if (arg0 == i) {
							pointViews.get(i).setBackgroundResource(R.drawable.point_selected);
						} else {
							pointViews.get(i).setBackgroundResource(R.drawable.point_normal);
						}
					}
	
				}
	
				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
	
				}
	
				@Override
				public void onPageScrollStateChanged(int arg0) {
	
				}
			});
			
			faceCategroyAdapter = new FaceCategroyAdapter(fragmentManager);
			
			
			sendButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if(onOperationListener != null && !"".equals(messageEditText.getText().toString().trim())){
						String content = messageEditText.getText().toString();
						onOperationListener.send(content);
						messageEditText.setText("");
					}
				}
			});
			
			//点击表情按钮
			faceButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if(faceLayout.getVisibility() == VISIBLE){
						hideFaceLayout();
						showKeyboard(context);
					}else{
						showFaceLayout();
					}
					
				}
			});
			
			//点击消息输入框
			messageEditText.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					hideFaceLayout();
				}
			});
			
			
			messageEditText.addTextChangedListener(new TextWatcher() {
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					if(s != null && !"".equals(s.toString().trim())){
						moreTypeButton.setVisibility(View.GONE);
						sendButton.setEnabled(true);
						sendButton.setVisibility(View.VISIBLE);
					}else{
						moreTypeButton.setVisibility(View.VISIBLE);
						if(moreTypeButton.getVisibility() == View.VISIBLE){
							sendButton.setVisibility(View.GONE);
						}
					}
				}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					
				}
				
				@Override
				public void afterTextChanged(Editable s) {
					
				}
			});
			
			
			//点击其他按钮
			moreTypeButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					hideKeyboard(context);
					
					postDelayed(new Runnable() {
						@Override
						public void run() {
							moreTypeLayout.setVisibility(View.GONE);
							faceLayout.setVisibility(View.VISIBLE);
							bottomHideLayout.setVisibility(View.VISIBLE);
						}
					}, 50);
				}
			});
			
		}

	public void showFaceLayout() {
		hideKeyboard(this.context);

		postDelayed(new Runnable() {
			@Override
			public void run() {
				moreTypeLayout.setVisibility(View.GONE);
				faceLayout.setVisibility(View.VISIBLE);
				bottomHideLayout.setVisibility(View.VISIBLE);
			}
		}, 50);
	}
	
	public void hideFaceLayout(){
		moreTypeLayout.setVisibility(View.GONE);
		faceLayout.setVisibility(View.GONE);
		bottomHideLayout.setVisibility(View.GONE);
	}
	
	public void hide(){
		bottomHideLayout.setVisibility(View.GONE);
		hideKeyboard(context);
	}
	
	/**
	 * 隐藏软键盘
	 * @param activity
	 */
	public static void hideKeyboard(Context context) {
		Activity activity = (Activity) context;
		if(activity != null){
			InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			if(imm.isActive() && activity.getCurrentFocus() != null){
				imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
			}
		}
	}

	/**
	 * 显示软键盘
	 * @param activity
	 */
	public static void showKeyboard(Context context) {
		Activity activity = (Activity) context;
		if(activity != null){
			InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.showSoftInputFromInputMethod(activity.getCurrentFocus().getWindowToken(), 0);
			imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	
	
	public OnOperationListener getOnOperationListener() {
		return onOperationListener;
	}

	public void setOnOperationListener(OnOperationListener onOperationListener) {
		this.onOperationListener = onOperationListener;
		faceCategroyAdapter.setOnOperationListener(onOperationListener);
	}

	public Map<Integer, ArrayList<String>> getFaceData() {
		return faceData;
	}

	public void setFaceData(Map<Integer, ArrayList<String>> faceData) {
		this.faceData = faceData;
		faceCategroyAdapter.setData(faceData);
		faceCategroyViewPager.setAdapter(faceCategroyAdapter);
		faceCategroyTabs.setViewPager(faceCategroyViewPager);
		if(faceData.size() < 2){
			faceCategroyTabs.setVisibility(GONE);
		}
	}

	public List<Option> getFunctionData() {
		return functionData;
	}

	public void setFunctionData(List<Option> functionData) {
		this.functionData = functionData;
		pointViews = new ArrayList<ImageView>();
		functionGridViewList = new ArrayList<View>(); 
		
		for (int x = 0; x < (functionData.size() % 8 == 0 ? functionData.size() / 8 : (functionData.size() / 8) + 1); x++) {
			GridView view = new GridView(context);
			FunctionAdapter functionAdapter = new FunctionAdapter(context, 
					functionData.subList(x * 8, 
							((x + 1) * 8) > functionData.size() ? functionData.size() : ((x + 1) * 8)));
			view.setAdapter(functionAdapter);
			// faceAdapters.add(emojiAdapter);

			view.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					if (onOperationListener != null) {
						onOperationListener.selectedFuncation(position);
					}
				}
			});
			view.setNumColumns(4);

			view.setBackgroundColor(Color.TRANSPARENT);
			view.setHorizontalSpacing(1);
			view.setVerticalSpacing(1);
			view.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
			view.setCacheColorHint(0);
			view.setPadding(5, 0, 5, 0);
			view.setSelector(new ColorDrawable(Color.TRANSPARENT));
			view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));
			view.setGravity(Gravity.CENTER);

			functionGridViewList.add(view);

			ImageView imageView = new ImageView(context);
			imageView.setBackgroundResource(R.drawable.point_normal);
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			layoutParams.leftMargin = 10;
			layoutParams.rightMargin = 10;
			layoutParams.width = 8;
			layoutParams.height = 8;
			pagePointLayout.addView(imageView, layoutParams);
			if (x == 0) {
				imageView.setBackgroundResource(R.drawable.point_selected);
			}
			pointViews.add(imageView);
		}

//		PagerAdapter facePagerAdapter = new FacePagerAdapter(functionGridViewList);
		fuctionViewPager.setAdapter(new PagerAdapter() {
			@Override
			public int getCount() {
				return functionGridViewList.size();
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getItemPosition(Object object) {
				return super.getItemPosition(object);
			}

			@Override
			public void destroyItem(View arg0, int arg1, Object arg2) {
				System.out.println(arg0 + "  " + arg1 + "  " + arg2);
				((ViewPager) arg0).removeView(functionGridViewList.get(arg1));
			}

			/***
			 * 获取每一个item?类于listview中的getview
			 */
			@Override
			public Object instantiateItem(View arg0, int arg1) {
				((ViewPager) arg0).addView(functionGridViewList.get(arg1));
				return functionGridViewList.get(arg1);
			}
			
		});
		
	}

	
	
	
	
}
