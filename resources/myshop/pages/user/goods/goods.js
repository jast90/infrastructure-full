// pages/goods/goods.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    allData: [{
        categoryId: 1,
        goods: [{
          productId: 1,
          productName: "白菜",
          productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"
        }, {
          productId: 1,
          productName: "包菜",
          productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"
        }]
      },
      {
        categoryId: 2,
        goods: [{
          productId: 1,
          productName: "烧鸭",
          productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"
        }, {
          productId: 1,
          productName: "白切鸡",
          productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"
        }]
      },
      {
        categoryId: 3,
        goods: [{
          productId: 1,
          productName: "香蕉",
          productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"
        }, {
          productId: 1,
          productName: "苹果",
          productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"
        }]
      },
      {
        categoryId: 4,
        goods: [{
          productId: 1,
          productName: "农夫山泉",
          productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"
        }, {
          productId: 1,
          productName: "怡宝",
          productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"
        }]
      }
    ],
    category: [{
      id: 1,
      name: "蔬菜"
    }, {
      id: 2,
      name: "熟食"
    }, {
      id: 3,
      name: "水果"
    }, {
      id: 4,
      name: "饮用水"
    }],
    product: [{
      productId: 1,
      productName: "商品名称",
      productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"
    }]
  },
  /**
   * 更改商品
   */
  changeProduct: function(e) {
    let id = e.target.dataset.id;
    console.log(id);
    let categoryGoods = this.data.allData;
    for (var i = 0; i < categoryGoods.length; i++) {
      var item = categoryGoods[i];
      if (item.categoryId === id) {
        this.setData({
          product: item.goods
        })
      }

    }
  },
  productInfo:function(e){
    let id = e.currentTarget.dataset.id;
    let goodInfoUrl = "/pages/user/goodsInfo/goodsInfo?id="+id;
    console.log(id);
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