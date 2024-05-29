<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
    <title>Menu</title>

    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/views/template/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/views/template/assets/css/owl-carousel.css"/>">

    <!-- MDB ESSENTIAL -->
    <link rel="stylesheet" href="<c:url value="/views/template/mdb/css/mdb.min.css"/>"/>
    <!-- MDB PLUGINS -->
    <link rel="stylesheet" href="<c:url value="/views/template/mdb/plugins/css/all.min.css"/>"/>

    <!-- Custom css-->
    <link rel="stylesheet" href="<c:url value="/views/template/custom/css/table.css"/>">

    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/sweetalert2@11">

</head>

<body>
<!-- ***** Header Area Start ***** -->
<%@ include file="layout/header.jsp" %>
<!-- ***** Header Area End ***** -->

<div class="main_content" style="margin-top: 100px">

    <!--Main layout-->
    <main class="mb-6">
        <div class="container">
            <div class="row gx-lg-5">
                <div class="col-lg-2 d-none d-lg-block">
                    <!-- Section: Filters -->
                    <section class="">
                        <!-- Section: Search -->
                        <section class="mb-5 mt-4">
                            <div class="d-flex">
                                <input
                                        id="search-text"
                                        type="search"
                                        class="form-control rounded me-1"
                                        placeholder="Tìm kiếm"
                                        aria-label="Search"
                                        aria-describedby="search-addon"
                                />
                                <a
                                        href="#!"
                                        role="button"
                                        class="
                        btn btn-link btn-floating
                        text-reset
                        overflow-visible
                        "
                                >
                                    <i class="fas fa-search"></i>
                                </a>
                            </div>
                        </section>
                        <!-- Section: Search -->

                        <!-- Section: Categories -->
                        <section class="mb-5">


                            <div class="text-muted small text-uppercase">
                                <a href="#!" data-category-value="0" class="font-weight-bold text-reset area-link"
                                   style="font-size: 20px; padding-bottom: 10px">Khu vực</a>
                                <c:forEach var="area" items="${areas}" varStatus="loop">
                                    <p class="mt-3">
                                        <a href="#!" class="text-reset area-link"
                                           data-category-value="${loop.index + 1}"
                                           style="text-transform: uppercase">${area.name}</a>
                                    </p>
                                </c:forEach>


                            </div>
                        </section>
                        <!-- Section: Categories -->

                    </section>
                    <!-- Section: Filters -->
                </div>
                <div class="col-lg-10">

                    <div class="mb-5">

                        <form class="d-flex justify-content-between flex-wrap">
                            <!-- Ngày Đặt -->
                            <div class=" col-md-2 mb-3">
                                <label for="filterDate" class="form-label ">Ngày Đặt:</label>
                                <input type="date" class="form-control" name="date" id="filterDate" value="">
                            </div>
                            <!-- Thời Gian Đặt -->
                            <div class="col-md mb-3">
                                <label for="filterStartTime" class="form-label">Thời Gian Đặt:</label>
                                <input type="time" class="form-control" id="filterStartTime" name="startTime"
                                       min="08:00" max="18:00">
                            </div>
                            <!-- Thời Gian Kết Thúc -->
                            <div class="col-md mb-3">
                                <label for="filterEndTime" class="form-label">Thời Gian Kết Thúc:</label>
                                <input type="time" class="form-control" name="startEnd" id="filterEndTime">
                            </div>

                            <!-- Số người -->
                            <div class="col-md-2 mb-3">
                                <label for="filterPeople" class="form-label">Số người:</label>
                                <input type="number" class="form-control" id="filterPeople" min="1" value="0"
                                       name="count">
                            </div>
                            <!-- Nút Áp Dụng -->
                            <div class="col-md-2 mb-3 d-flex align-items-end pb-1 justify-content-center">

                                <div>
                                    <button type="button" class="btn btn-primary" id="find">Tìm kiếm
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="row gx-xl-5 justify-content-center" id="yourContainer">


                    </div>
                    <ul class="pagination" id="pagination"></ul>
                    <input type="hidden" value="" id="page" name="page">
                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem">
                </div>


            </div>
        </div>


    </main>
    <!--Main layout-->


    <!-- ***** Main Banner Area Start ***** -->

    <!-- ***** Main Banner Area End ***** -->


</div>
<!-- ***** Footer Start ***** -->
<%@ include file="layout/footer.jsp" %>
<!-- ***** Footer End ***** -->
<!-- jQuery -->
<script src="<c:url value="/views/template/assets/js/jquery-2.1.0.min.js"/>"></script>
<!---->
<!---->
<script src="<c:url value="/views/template/paging/jquery.twbsPagination.min.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">

    let totalPages = ${totalPage};
    let currentPage = 1;
    const limit = 9;
    let count = $('#filterPeople').val();
    let startTime = "0000-00-00 00:00:00";
    let endTime = "0000-00-00 00:00:00";


    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 5,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    currentPage = page;
                    count = $('#filterPeople').val();
                    ajaxRun(startTime, endTime, count);
                }
            }
        });
    });

    // 5.1.4.2 Hàm find() để tìm kiếm bàn trống
    $('#find').click(function () {
        count = 0;
        //Kiểm tra xem phần tử có ID là filterDate có giá trị hay không. Nếu có, nghĩa là người dùng đã chọn ngày đặt bàn.
        if ($('#filterDate').val()) {
            //Tạo chuỗi thời gian bắt đầu (startTime) và thời gian kết thúc (endTime)
            // bằng cách kết hợp ngày đặt bàn với giờ phút được chọn từ các phần tử tương ứng.
            startTime = $('#filterDate').val() + " " + $('#filterStartTime').val() + ":00";
            endTime = $('#filterDate').val() + " " + $('#filterEndTime').val() + ":00";

            // count = $('#filterPeople').val();
            count = $('#filterPeople').val();

            // Gọi hàm checkTime với các tham số startTime và endTime. Nếu hàm trả về true,
            // nghĩa là thời gian hợp lệ, sau đó gọi hàm ajaxRun với các tham số cần thiết để thực hiện yêu cầu AJAX.
            if (checkTime(startTime, endTime)) {
                ajaxRun(startTime, endTime, count);
            }

        } else {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Vui lòng chọn ngày đặt bàn!",
            });
        }
    });

    // 5.1.4.3 Hàm checkTime để kiểm tra giờ
    function checkTime(startTime, endTime) {
        var currentDate = new Date(); // Tạo đối tượng Date lấy giờ hiện tại
        var currentDateTimePlus15Minutes = new Date(); // Tạo một đối tượng Date mới
        currentDateTimePlus15Minutes.setMinutes(currentDateTimePlus15Minutes.getMinutes() + 15); // và thiết lập phút của nó cộng thêm 15 phút so với thời gian hiện tại.

        // Chuyển đổi chuỗi thời gian bắt đầu (startTime) và thời gian kết thúc (endTime) sang đối tượng Date.
        var parsedStartTime = new Date(startTime);
        var parsedEndTime = new Date(endTime);

        // Nếu thời gian bắt đầu (parsedStartTime) lớn hơn thời gian hiện tại cộng 15 phút (currentDateTimePlus15Minutes),
        // thì tiếp tục kiểm tra tiếp theo.
        if (parsedStartTime > currentDateTimePlus15Minutes) {
            if (parsedEndTime > parsedStartTime) { // Nếu thời gian kết thúc (parsedEndTime) lớn hơn thời gian bắt đầu (parsedStartTime), hàm trả về true.
                return true;
            } else { // Ngược lại, hiện thông báo lỗi bằng Swal.fire và trả về false.
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Thời gian kết thúc phải lớn hơn thời gian bắt đầu 15 phút!",
                });
            }
        } else { //Nếu thời gian bắt đầu (parsedStartTime) không lớn hơn thời gian hiện tại cộng 15 phút (currentDateTimePlus15Minutes),
            // hiện thông báo lỗi bằng Swal.fire và trả về false.
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Thời gian bắt đầu phải lớn hơn thời gian hiện tại 15 phút!",
            });
        }
        return false;
    }

    // Phương thức xử lý ajaxRun để gửi yêu cầu AJAX đến máy chủ và nhận kết quả trả về.
    // Phương thức này nhận ba tham số: startTime, endTime và count.
    // Cách thức hoạt động:
    // `1. ửi các tham số từ người dùng nhập
    // `2. Gửi yêu cầu AJAX đến máy chủ
    // `3. Nhận kết quả trả về từ máy chủ
    // `4. Hiển thị kết quả trả về lên trang web (render dữ liệu ra trang table.jsp)
    function ajaxRun(startTime, endTime, count) {
        $.ajax({
            type: "Post",

            url: "/tables?count=" + count +  "&startTime=" + startTime + "&endTime=" + endTime ,

            ContentType: 'json',
            headers: {Accept: "application/json;charset=utf-8"},
            success: function (json) {
                let data = "";
                let obj = json;
                for (let i = 0; i < obj.length; i++) {
                    let val = obj[i];
                    // onclick="return theFunction();"
                    data += "<div class=\"col-lg-4 col-6 mb-4\">"
                        + "<div class=\"bg-image ripple shadow-4-soft rounded-6 mb-4 overflow-hidden d-block table_main\" data-ripple-color=\"light\">"
                        + "<img src=\"" + val.image + "\" class=\"w-100\" alt=\"\"/>"
                        + "<div class=\"hover-overlay table_omega text-center\">"
                        + "<br>"
                        + "<h4>Số bàn: " + val.tableNum + "</h4>"
                        + "<h4>Chỗ ngồi: " + val.seatCount + " người</h4>"
                        + "<h4>Vị trí: " + val.location + "</h4>"
                        + "<div class=\"button-container\">"
                        + "<button class=\"btn btn-primary yourBookButton\" style=\"text-transform: uppercase\" onclick=\"checkTimeAndRedirect('" + val.id + "', '" + startTime + "', '" + endTime + "' )\">Chọn bàn</button>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                        + "</div>";
                }
                $("#yourContainer").html(data);
            }
        });
    }

    ajaxRun(startTime, endTime, count);

</script>


<script type="text/javascript" src="<c:url value="/views/template/mdb/js/mdb.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/views/template/mdb/plugins/js/all.min.js"/>"></script>
<script src="<c:url value="/views/template/mdb/js/mdb.umd.min.js"/>"></script>

</body>
</html>