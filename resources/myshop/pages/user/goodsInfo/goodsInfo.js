// pages/goodsInfo/goodsInfo.js
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
      productId: 1,
      productName: "白菜",
      productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132",
      productImages: ["https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132", "https://avatars3.githubusercontent.com/u/17826333?s=400&v=4", "https://avatars3.githubusercontent.com/u/501740?s=400&v=4"]
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id)
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