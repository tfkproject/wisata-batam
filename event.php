<!DOCTYPE html>
<html lang="en">
    <?php include("koneksi.php");?>
  <?php include("head.php");?>
  <body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <?php include("header.php");?>
    <!-- Sidebar menu-->
    <?php include("sidebar.php");?>
    <main class="app-content">
      <div class="app-title">
        <a href="event_tambah.php" class="btn btn-primary icon-btn"><i class="fa fa-plus"></i>Add Item	</a>
        
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item"><a href="#">Wisata</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <h3 class="tile-title">Event</h3>
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>No</th>
                  <th>Tanggal</th>
                  <th>Event</th>
                  <th>Aksi</th>
                </tr>
              </thead>
              <tbody>
              <?php
              $sql = "select * from tbl_event order by tanggal desc";
              $eks = mysqli_query($conn, $sql);
              $no = 1;
              while($row = mysqli_fetch_array($eks)){
              ?>
                <tr>
                  <td><?php echo $no++;?></td>
                  <td><?php echo $row['tanggal'];?></td>
                  <td><?php echo $row['event'];?></td>
                  <td><a href="event_edit.php?id=<?php echo $row['id_event'];?>" class="btn btn-primary icon-btn"><i class="fa fa-pencil"></i></a>
                    &nbsp;<a href="event_hapus.php?id=<?php echo $row['id_event'];?>" class="btn btn-danger icon-btn" onclick="return confirm('Yakin menghapus data?');"><i class="fa fa-trash"></i></a></td>
                </tr>
              <?php
              }
              ?>
              </tbody>
            </table>
          </div>
        </div>
        
      </div>
    </main>
    <!-- Essential javascripts for application to work-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="js/plugins/pace.min.js"></script>
    <!-- Page specific javascripts-->
    <!-- Google analytics script-->
    <script type="text/javascript">
      if(document.location.hostname == 'pratikborsadiya.in') {
      	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      	})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      	ga('create', 'UA-72504830-1', 'auto');
      	ga('send', 'pageview');
      }
    </script>
  </body>
</html>