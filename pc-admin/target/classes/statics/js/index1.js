
//分页功能
function pagerFilter(data) {
    data = {
        total: data.data.total,
        rows: data.data.rows
    }
    return data;
}
    $(function() {
     alert('1');
    $('#dg').datagrid({
        url: sys_menu_url.menu_list,
        loadFilter: pagerFilter

    });

});