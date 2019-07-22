// var api = require("/utils/api.js")
var api = require("../../../utils/mock.js")

Page({

  /**
   * 页面的初始数据
   */
  data: {
    categories: [],
    products: []
  },
  /**
   * 更改商品
   */
  changeProduct: function(e) {
    let categoryId = e.target.dataset.id;
    let that = this;
    api.getProductList({ categoryId: categoryId }, function (data) {
      that.setData({ products: data });
    });
  },
  productInfo:function(e){
    let productId = e.currentTarget.dataset.id;
    let goodInfoUrl = "/pages/user/goodsInfo/goodsInfo?id=" + productId;
    wx.navigateTo({
      url: goodInfoUrl
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
    var that = this;
    api.getCategoryList(function (data) {
      that.setData({ categories: data });
    });
    var categoryId = this.data.categories[0].id;
    api.getProductList({ categoryId: categoryId }, function (data) {
      that.setData({ products: data });
    });
    console.log(this.data)
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