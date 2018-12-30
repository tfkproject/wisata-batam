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
        <button class="btn btn-secondary icon-btn btn-small" onclick="history.back(-1);"><i class="fa fa-arrow-left"></i>Kembali	</button>
        
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item"><a href="#">Wisata</a></li>
        </ul>
      </div>
      <div class="row">
          
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title">Tambah Data</h3>
            <div class="tile-body">
              <form action="tambah_proses.php" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                  <label class="control-label">Nama</label>
                  <input class="form-control" type="text" name="nama" placeholder="Nama">
                </div>
                <div class="form-group">
                  <label class="control-label">Lokasi</label>
                  <input class="form-control" type="text" name="lokasi" placeholder="Lokasi">
                </div>
                <div class="form-group">
                  <label class="control-label">Foto covery</label>
                  <input class="form-control" type="file" name="gambar">
                </div>
                <div class="form-group">
                  <label class="control-label">Deskripsi</label>
                  <textarea class="form-control" name="deskripsi"></textarea>
                </div>
                <div class="form-group">
                  <label class="control-label">Latitude</label>
                  <input class="form-control" type="text" name="latitude" placeholder="Latitude">
                </div>
                <div class="form-group">
                  <label class="control-label">Longitude</label>
                  <input class="form-control" type="text" name="longitude" placeholder="Longitude">
                </div>
                <div class="tile-footer">
                  <button class="btn btn-primary" type="submit"><i class="fa fa-fw fa-lg fa-check-circle"></i>Submit</button>
                </div>
              </form>
            </div>
            
          </div>
        </div>
        
        <div class="clearfix"></div>
        
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