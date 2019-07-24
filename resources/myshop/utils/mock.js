/**
 * 获取分类
 */
function getCategoryList(callback) {
  var categories = [{
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
  }, {
    id: 5,
    name: "快消品"
  }];
  console.log(categories)
  callback(categories);
}

/**
 * 根据类型获取商品列表
 */
function getProductList(data, callback) {
  var categoryProductsArray = [{
      categoryId: 1,
      goods: [{
        productId: 1,
        productName: "白菜",
        productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132",
        productDesc: "有机白菜，无污染"
      }, {
        productId: 2,
        productName: "包菜",
        productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132",
        productDesc: "有机白菜，无污染"
      }]
    },
    {
      categoryId: 2,
      goods: [{
        productId: 3,
        productName: "烧鸭",
        productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132",
        productDesc: "有机白菜，无污染"
      }, {
        productId: 4,
        productName: "白切鸡",
        productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132",
        productDesc: "有机白菜，无污染"
      }]
    },
    {
      categoryId: 3,
      goods: [{
        productId: 5,
        productName: "香蕉",
        productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132",
        productDesc: "有机白菜，无污染"
      }, {
        productId: 6,
        productName: "苹果",
        productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132",
        productDesc: "有机白菜，无污染"
      }]
    },
    {
      categoryId: 4,
      goods: [{
        productId: 7,
        productName: "农夫山泉",
        productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132",
        productDesc: "有机白菜，无污染"
      }, {
        productId: 8,
        productName: "怡宝",
        productImage: "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132",
        productDesc: "有机白菜，无污染"
      }]
    }
  ];
  var products = [];
  for (var index in categoryProductsArray) {
    var categoryProducts = categoryProductsArray[index];
    if (categoryProducts.categoryId == data.categoryId) {
      products = categoryProducts.goods;
      break;
    }
  }
  callback(products);
}

/**
 * 商品详情
 */
function getProductDetail(data, callback) {
  var products = [{
    productId: 1,
    productName: "白菜",
    productImages: ["https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"],
    productDesc: "有机白菜，无污染"
  }, {
    productId: 2,
    productName: "包菜",
    productImages: ["https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"],
    productDesc: "有机白菜，无污染"
  }, {
    productId: 3,
    productName: "烧鸭",
    productImages: ["https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"],
    productDesc: "有机白菜，无污染"
  }, {
    productId: 4,
    productName: "白切鸡",
    productImages: ["https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"],
    productDesc: "有机白菜，无污染"
  }, {
    productId: 5,
    productName: "香蕉",
    productImages: ["https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"],
    productDesc: "有机白菜，无污染"
  }, {
    productId: 6,
    productName: "苹果",
    productImages: ["https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"],
    productDesc: "有机白菜，无污染"
  }, {
    productId: 7,
    productName: "农夫山泉",
    productImages: ["https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"],
    productDesc: "有机白菜，无污染"
  }, {
    productId: 8,
    productName: "怡宝",
    productImages: ["https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132"],
    productDesc: "有机白菜，无污染"
  }];
  var product;
  for (var index in products) {
    var product = products[index];
    if (product.productId == data.productId) {
      product = product;
      break;
    }
  }
  callback(product);
}

/**
 * 更新用户收款码
 */
function updateUserQRCode(data, callback) {
  console.log(data)
  var result = {
    resultCode: 0,
    resultMsg: "操作成功"
  }
  callback(result);
}

/**
 * 获取用户收款码
 */
function getUserQRCode(data, callback) {
  console.log(getUserQRCode);
  var qrcode = "https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epiadUN7FMBBlymlW9QEWJzNbPN04lgkFh1P9J91L7kWPcNyJHF7rfyPqMFa1Qpqb9yxZzFZia12oDw/132";
  callback(qrcode);
}

/**
 * 添加分类
 */
function categoryAdd(data, callback) {
  console.log(data)
  var result = {
    resultCode: 0,
    resultMsg: "操作成功"
  }
  callback(result);
}

function cartAdd(data,callback){
  console.log(data)
  var result = {
    resultCode: 0,
    resultMsg: "操作成功"
  }
  callback(result);
}

function getCart(callback){
  var result = [
    { productId: 2, qty: 1 }
  ]
  callback(result);
}

/**
 * API
 * @type {{post: post, get: get}}
 */
module.exports = {
  getCategoryList: getCategoryList,
  getProductList: getProductList,
  getProductDetail: getProductDetail,
  getUserQRCode: getUserQRCode,
  updateUserQRCode: updateUserQRCode,
  categoryAdd: categoryAdd,
  cartAdd: cartAdd,
  getCart: getCart
}