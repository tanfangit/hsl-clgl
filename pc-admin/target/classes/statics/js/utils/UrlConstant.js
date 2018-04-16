
var contextPath = window.baseUrl;
//系统登录路径
var sys_login_url = new Object();
sys_login_url.sys_login=contextPath+'/sys/login';
//商户管理列表查询
var business_mmanager_url = new Object();
business_mmanager_url.business_page=contextPath+'/businessmanager/list';

//系统用户
var sys_user_url = new Object();
//查询系统用户列表
sys_user_url.user_list=contextPath+'/sys/user/list';
//新增用户
sys_user_url.user_add=contextPath+'/sys/user/save';
//查询用户
sys_user_url.user_selectone=contextPath+'/sys/user/info/';
//删除用户
sys_user_url.user_delete=contextPath+'/sys/user/delete/';
//修改用户
sys_user_url.user_update=contextPath+'/sys/user/update/';

//部门
var sys_dept_url = new Object();
//部门树查询
sys_dept_url.dept_tree=contextPath+'/sys/dept/tree';
//部门分页查询
sys_dept_url.dept_list=contextPath+'/sys/dept/list';
//新增部门
sys_dept_url.dept_add=contextPath+'/sys/dept/save';
//查询部门信息
sys_dept_url.dept_selectone=contextPath+'/sys/dept/info/';
//修改部门信息
sys_dept_url.dept_update=contextPath+'/sys/dept/update';
//删除部门
sys_dept_url.dept_delete=contextPath+'/sys/dept/delete/';


//系统角色
var sys_role_url = new Object();
//角色列表查询
sys_role_url.role_list=contextPath+'/sys/sysrole/list';
//查询所有角色
sys_role_url.role_roles=contextPath+'/sys/sysrole/roles';
//删除角色
sys_role_url.role_delete=contextPath+'/sys/sysrole/delete/';
//新增角色
sys_role_url.role_save=contextPath+'/sys/sysrole/save';
//查询角色信息
sys_role_url.role_select=contextPath+'/sys/sysrole/info/';
//修改角色
sys_role_url.role_update=contextPath+'/sys/sysrole/update';


var sys_menu_url = new Object();
//查询系统菜单
sys_menu_url.nav=contextPath+'/sys/menu/nav';
//查询菜单树结构
sys_menu_url.menu_tree=contextPath+'/sys/menu/tree';
//查询菜单树结构
sys_menu_url.menu_selectTree=contextPath+'/sys/menu/selectTree';

//车辆品牌查询
var car_brand_url = new Object();
car_brand_url.brand_list=contextPath+'/car/brand/list';
car_brand_url.brand_save=contextPath+'/car/brand/save';
car_brand_url.brand_update=contextPath+'/car/brand/update';
car_brand_url.brand_delete=contextPath+'/car/brand/delete/';
car_brand_url.brand_select=contextPath+'/car/brand/select';
//车系查询
var car_train_url = new Object();
car_train_url.train_list=contextPath+'/car/train/list';
car_train_url.train_save=contextPath+'/car/train/save';
car_train_url.train_update=contextPath+'/car/train/update';
car_train_url.train_delete=contextPath+'/car/train/delete/';
car_train_url.train_select=contextPath+'/car/train/select/';
//车型查询
var car_type_url = new Object();
car_type_url.type_list=contextPath+'/car/type/list';
car_type_url.type_save=contextPath+'/car/type/save';
car_type_url.type_update=contextPath+'/car/type/update';
car_type_url.type_delete=contextPath+'/car/type/delete/';
//查询所有车型
car_type_url.type_allType=contextPath+'/car/type/allType';
//商户管理
var merchant_url = new Object();
merchant_url.merchant_list=contextPath+'/merchant/list';
merchant_url.merchant_save=contextPath+'/merchant/save';
merchant_url.merchant_update=contextPath+'/merchant/update';
merchant_url.merchant_delete=contextPath+'/merchant/delete/';
merchant_url.merchant_repair_type=contextPath+'/merchant/repair/';
merchant_url.merchant_mapCheck=contextPath+'/merchant/mapCheck';
merchant_url.merchant_polygonSave=contextPath+'/merchant/polygonSave';
merchant_url.merchant_queryByCityCode=contextPath+'/merchant/queryByCityCode';
merchant_url.merchant_savePoint=contextPath+'/merchant/savePoint';
var supplier_view_url = new Object();
//列表显示所有供应商
supplier_view_url.supplier_list=contextPath+'/supplier/list';

var supplier_add_url = new Object();
//供应商添加
supplier_add_url.supplier_add=contextPath+'/supplier/save';

var supplier_edit_url = new Object();
//供应商修改
supplier_edit_url.supplier_edit=contextPath+'/supplier/update';

var supplier_find_url = new Object();
//供应商修搜索
supplier_find_url.supplier_find=contextPath+'/supplier/info/{supplierId}';

var parts_view_url = new Object();
//查询所有配件
parts_view_url.parts_list=contextPath+'/parts/list';

var parts_add_url = new Object();
//新增配件
parts_add_url.parts_add=contextPath+'/parts/save';

var parts_edit_url = new Object();
//修改配件
parts_edit_url.parts_edit=contextPath+'/parts/update';

var parts_delete_url = new Object();
// 删除配件(仅限单记录删除)
parts_delete_url.parts_delete=contextPath+'/parts/delete/';

//var company_view_url = new Object();
var trailer_company_url = new Object();
// 查询所有拖车公司
trailer_company_url.company_view=contextPath+'/trailer/company/list';
//var company_add_url = new Object();
// 拖车公司新增
trailer_company_url.company_add=contextPath+'/trailer/company/save';
//var company_edit_url = new Object();
// 拖车公司修改
trailer_company_url.company_edit=contextPath+'/trailer/company/update';
//查询所有拖车公司
trailer_company_url.company_all=contextPath+'/trailer/company/allTrailerCompany';

//拖车管理
var trailer_url = new Object();
trailer_url.trailer_view=contextPath+'/trailer/trailerList/list';
trailer_url.trailer_add=contextPath+'/trailer/trailerList/save';
trailer_url.trailer_edit=contextPath+'/trailer/trailerList/update';
//拖车单管理
var trailerList_url = new Object();
trailerList_url.trailerList_view=contextPath+'/trailerlist/list';
trailerList_url.trailerList_edit=contextPath+'/trailerlist/update';
//维修类别
var repair_type_url = new Object();
//列表查询
repair_type_url.type_list=contextPath+'/repair/repairtype/list';
//新增
repair_type_url.type_save=contextPath+'/repair/repairtype/save';
//查询
repair_type_url.type_info=contextPath+'/repair/repairtype/info/';
//编辑
repair_type_url.type_update=contextPath+'/repair/repairtype/update/';
//删除
repair_type_url.type_delete=contextPath+'/repair/repairtype/delete/';
//查询所有维修类别
repair_type_url.type_all=contextPath+'/repair/repairtype/all';


//维修项目
var repair_item_url = new Object();
//列表查询
repair_item_url.item_list=contextPath+'/repair/repairitem/list';
//新增
repair_item_url.item_save=contextPath+'/repair/repairitem/save';
//通过维修项目id 查询维修项目信息
repair_item_url.item_info=contextPath+'/repair/repairitem/info/';
//修改
repair_item_url.item_update=contextPath+'/repair/repairitem/update';
//删除
repair_item_url.item_delete=contextPath+'/repair/repairitem/delete/';



//字典表
var dict_url = new Object();
//通过：通过字典类型  查询字典List
dict_url.dict_list=contextPath+'/dictype/list';
dict_url.dict_add=contextPath+'/dictype/save';
dict_url.dict_edit=contextPath+'/dictype/update';
dict_url.dict_delete=contextPath+'/dictype/delete/';
//字典值表
var dict_value_url = new Object();
dict_value_url.dict_list=contextPath+'/dicvalue/list';
dict_value_url.dict_add=contextPath+'/dicvalue/save';
dict_value_url.dict_edit=contextPath+'/dicvalue/update';
dict_value_url.dict_delete=contextPath+'/dicvalue/delete/';
//通过字典类型查询 字典值List
dict_value_url.dict_query=contextPath+'/dicvalue/query/';
//repair_type_url.type_delete=contextPath+'/repair/repairtype/delete/';
//repair_type_url.type_delete=contextPath+'/repair/repairtype/delete/';
//repair_type_url.item_list=contextPath+'/repair/repairtype/list';

//地区信息加载地址
var area_url = new Object();
area_url.province_list=contextPath+'/area/sj/list';
area_url.city_list=contextPath+'/area/dj/parentId/';

//车主管理
var cz_manager_url = new Object();
//列表查询
cz_manager_url.cz_list=contextPath+'/cz/list';
//信息查询
cz_manager_url.cz_info=contextPath+'/cz/info/';

//拖车司机管理
var trailer_driver_url = new Object();
trailer_driver_url.driver_list=contextPath+'/trailer/trailerdriver/list';
trailer_driver_url.driver_save=contextPath+'/trailer/trailerdriver/save';
trailer_driver_url.driver_info=contextPath+'/trailer/trailerdriver/info/';
trailer_driver_url.driver_update=contextPath+'/trailer/trailerdriver/update';
