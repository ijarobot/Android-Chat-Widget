Android-Chat-Widget
===================

An Android Chat Widget, like WhatsApp \ Line \ WeChat


Demo
===================
![](http://git.oschina.net/ijarobot/Android-Chat-Widget/raw/master/Android-Chat-Widget-Example/chatdemo.gif)



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
[http://jingdl.com/blog/2014/12/06/android-liao-tian-kong-jian-android-chat-widget/](http://jingdl.com/blog/2014/12/06/android-liao-tian-kong-jian-android-chat-widget/)

招聘广告
===================
招聘 php 工程师4枚，ios，android工程师各2枚，深圳科技园非常有前途的创业公司，国内优秀SaaS服务提供商，全员持股！ 需要的QQ( 48407606 / 295893265) ！
