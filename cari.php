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
        <a href="tambah.php" class="btn btn-primary icon-btn"><i class="fa fa-plus"></i>Add Item	</a>
        <?php $keyword = $_GET['q']; ?>
        <p>Pencarian: <strong><?php echo $keyword;?></strong>&nbsp;&nbsp;<a href="home.php"><i class="fa fa-close" style="color:red;"></i></a></p>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item"><a href="#">Wisata</a></li>
        </ul>
      </div>
      <div class="row">
        
        <?php
        $sql = "select * from tbl_wisata where nama_objek like '%$keyword%' order by id_wisata asc";
        $eks = mysqli_query($conn, $sql);
        while($row = mysqli_fetch_array($eks)){
        ?>
        <div class="col-md-6">
          <div class="tile">
            <div class="tile-title-w-btn">
              <h3 class="title"><?php echo $row['nama_objek'];?></h3>
              <?php
              $id = $row['id_wisata'];
              $param = "id_wisata=".$id;
              ?>
              <div class="btn-group"><a class="btn btn-primary" href="edit.php?<?php echo $param;?>"><i class="fa fa-lg fa-edit"></i></a><a class="btn btn-primary" href="hapus.php?<?php echo $param;?>" onClick="return confirm('Yakin ingin menghapus data?');"><i class="fa fa-lg fa-trash"></i></a></div>
            </div>
            <div class="tile-body">
              <b><i class="fa fa-lg fa-map-marker"></i>&nbsp;&nbsp;<?php echo $row['lokasi'];?> </b><br><br>
              <img src="images/wisata/<?php echo $row['foto_cover'];?>" width="100%" style="border-radius: 1%;">
              <p><?php
                $desk = strip_tags($row['deskripsi']); // membuat paragraf pada isi berita dan mengabaikan tag html
				$isi = substr($desk,0,50); // ambil sebanyak 50 karakter
				$isi = substr($desk,0,strrpos($isi," ")); // potong per spasi kalimat
				echo $isi."...";?></p>
            </div>
          </div>
        </div>
        <?php
        }
        ?>
        
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