# Jiuyuantong


这是一个仿江西财经大学的校园APP"财大通"做的一个九江学院的"九院通"练习APP,
主要分四个模块"学校生活","出行指南","游玩九江","号码百事通"

主界面:
--
![](https://github.com/huyuxin95/Jiuyuantong/blob/master/images/01.png)
学校生活:
--

![](https://github.com/huyuxin95/Jiuyuantong/blob/master/images/02.png)

 - 校园平面图:
 这用Spinner控件对校区进行选择,下面图片显示相应的校区图片,图片实现拖动,双指放大与缩小
![](https://github.com/huyuxin95/Jiuyuantong/blob/master/images/03.png)
 - 校园风景
这用的别人写的自定义控件HorizontalListView
![](https://github.com/huyuxin95/Jiuyuantong/blob/master/images/04.png)

出行指南
--
出行指南模块是用的百度地图的SDK,实现对位置的定位,公交线路查询,poi查询
![](https://github.com/huyuxin95/Jiuyuantong/blob/master/images/06.png)

 - 公交线路查询

![](https://github.com/huyuxin95/Jiuyuantong/blob/master/images/08.png)

 - poi查询

![](https://github.com/huyuxin95/Jiuyuantong/blob/master/images/09.png)

游玩九江
--
这里用的一个listview实现
![](https://github.com/huyuxin95/Jiuyuantong/blob/master/images/10.png)
号码百事通
--
这个模块用的ExpandableListView,查询数据库的两张关联的表,右上角用PopupWindow实现对数据库的增加,其他删除修改没加,
![](https://github.com/huyuxin95/Jiuyuantong/blob/master/images/11.png)
