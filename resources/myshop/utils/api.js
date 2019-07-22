var host = "";
/**
 * 发送POST请求
 */
function post(host, url, data, callback) {
  wx.request({
    url: host + url,
    data: JSON.stringify(data),
    method: "POST",
    success: function (res) {
      callback.success(res);
    },
    fail: function (res) {
      console.error("fail:" + res);
    },
    complete: function (res) {
      callback.complete(res);
    }
  });
}

function post(url,data,callback){
  post(host, url, data, callback);
}

/**
* 发送get请求
*/
function get(host, url, callback) {
  wx.request({
    url: host + url,
    method: "GET",
    success: function (res) {
      callback.success(res);
    },
    fail: function (res) {
      console.error("fail:" + res);
    },
    complete: function (res) {
      callback.complete(res);
    }
  });
}

function get(url,callback){
  get(host,url,callback);
}

/**
 * 获取分类
 */
function getCategoryList(callback){
  var url = "/category/list";
  get(url,callback);
}

/**
 * 获取商品列表
 */
function getProductList(data,callback){
  var url = "/product/list";
  post(url,data,callback);
}

/**
 * 商品详情
 */
function getProductDetail(data, callback) {
  var url = "/product/"+data.productId;
  get(url,callback);
}

/**
* API
* @type {{post: post, get: get}}
*/
module.exports = {
  getCategoryList: getCategoryList,
  getProductList: getProductList,
  getProductDetail: getProductDetail
}