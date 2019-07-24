// var api = require("/utils/api.js")
var api = require("../../../utils/mock.js")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    indicatorDots: false,
    autoplay: true,
    interval: 5000,
    duration: 1000,
    product: {
    },
    cart:[],
    cartQty:0
  },
  cart:function(){
    wx.navigateTo({
      url: "/pages/user/cart/cart"
    })
  },
  order:function(){
    wx.navigateTo({
      url: "/pages/user/order/order"
    })
  },
  addCart:function(){
    api.cartAdd({
      productId: this.data.product.productId,
      qty:1
    },data=>{
      if(data.resultCode==0){
        wx.showToast({
          title: '操作成功',
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let productId = options.id;
    api.getProductDetail({productId:productId},data=>this.setData({product:data}));
    api.getCart(data => { 
        this.setData({ cart: data }) 
        let qty = 0;
        let index;
        for(index in data ){
          qty +=data[index].qty;
        }
      this.setData({ cartQty: qty }) 
      });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})