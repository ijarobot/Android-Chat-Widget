Android-Chat-Widget
===================

An Android Chat Widget, like WhatsApp \ Line \ WeChat


Demo
===================
![](https://raw.githubusercontent.com/ijarobot/Android-Chat-Widget/master/Android-Chat-Widget-Example/chatdemo.gif)



How to use?
===================
1.In Layout


     <com.jialin.chat.MessageInputToolBox
        android:id="@+id/messageInputToolBox"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" 
      />


2.In Activity

    	/**
    	 * init MessageInputToolBox
    	 */
    	private void initMessageInputToolBox() {
    		box = (MessageInputToolBox) findViewById(R.id.messageInputToolBox);
    
    		box.setOnOperationListener(new OnOperationListener() {
    
    			@Override
    			public void send(String content) {
    				// TODO
    			}
    
    			@Override
    			public void selectedFace(String content) {
    				// TODO
    			}
    
    			@Override
    			public void selectedFuncation(int index) {
    				// TODO
    			}
    
    		});
    
    		box.setFaceData(faceData);
    
    		box.setFunctionData(functionData);
    	}
		
		
Tips
===================		

Run Android-Chat-Widget-Example, need reference android-support-v7-appcompat project


Blog
===================	
[http://jingdl.com/blog/android-liao-tian-kong-jian-android-chat-widget/](http://jingdl.com/blog/android-liao-tian-kong-jian-android-chat-widget/)

