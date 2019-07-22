// pages/home/home.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    menus:[
      {
        id:1,
        name:"分类管理",
        url:"/pages/merchant/category/category"
      },
      {
        id: 2,
        name: "商品管理",
        url: "/pages/merchant/goods/goods"
      },
      {
        id: 3,
        name: "收款码",
        url: "/pages/merchant/qrcode/qrcode"
      }
    ]
  },

  navigate:function(e){
    let url = e.currentTarget.dataset.url;
    console.log(url);
    wx.navigateTo({
      url: url
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})