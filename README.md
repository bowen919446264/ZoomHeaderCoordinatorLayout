# ZoomHeaderCoordinatorLayout
pull zoom CoordinatorLayout

集成至CoordinatorLayout 增加PullZoom的功能

此工程参考了PullToZoom项目
调用这个方法可以开启pull zoom 功能， 需要自己实现IPullZoom 里面的isReadyForPullStart方法。
/**
     * 不设置这些信息就没有zoom相关的效果
     *
     * @param zoomView
     * @param zoomViewHeight
     * @param maxZoomViewHeight 0为无穷大
     * @param pullZoom
     */
    public void setPullZoom(View zoomView, int zoomViewHeight, int maxZoomViewHeight, IPullZoom pullZoom) {
        this.mZoomView = zoomView;
        mZoomViewHeight = zoomViewHeight;
        mZoomViewMaxHeight = maxZoomViewHeight;
        mPullZoom = pullZoom;
        //防止 onInterceptTouchEvent的ACTION_MOVE事件不执行，避免就是子view的down事件返回fasle
        mZoomView.setClickable(true);
    }
    
   
![image](https://github.com/bowen919446264/ZoomHeaderCoordinatorLayout/blob/master/screen/1.jpg)
![image](https://github.com/bowen919446264/ZoomHeaderCoordinatorLayout/blob/master/screen/2.jpg)
