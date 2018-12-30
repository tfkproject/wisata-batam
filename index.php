<!DOCTYPE html>
<html>
  <?php include("head.php");?>
  <body>
    <section class="material-half-bg">
      <div class="cover"></div>
    </section>
    <section class="login-content">
      <div class="logo">
        <h1>Aplikasi Objek Wisata Kota Batam</h1>
      </div>
      <div class="login-box">

        <?php 
          /**
          * Pesan Error Bila terjadi kegagalan dalam login
          */
          if (isset($_GET['login']) && $_GET['login'] == 'salah') {
            ?>
              <div class="alert alert-danger alert-dismissible" role="alert">
                <!-- <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
                Maaf email atau password salah!
              </div>
            <?php
          }
          if (isset($_GET['login']) && $_GET['login'] == 'kosong') {
            ?>
              <div class="alert alert-warning alert-dismissible" role="alert">
                <!-- <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
                Email atau password tidak boleh kosong!
              </div>
            <?php
          }
        ?>

        <form class="login-form" action="login.php" method="POST">
          <h3 class="login-head">
              <!--<i class="fa fa-lg fa-fw fa-user"></i>
          <!-- Disini logo pemko Batam -->
            <img src="images/Logo-Kota-BATAM.png" width="25%"><br>
            Pemko Batam
          </h3>
          <div class="form-group">
            <!--<label class="control-label">Username</label>-->
            <input name="username" class="form-control" type="text" placeholder="Username" autofocus>
          </div>
          <div class="form-group">
            <!--<label class="control-label">Password</label>-->
            <input name="password" class="form-control" type="password" placeholder="Password">
          </div>
          <br>
          <!--<div class="form-group">
            <div class="utility">
              <div class="animated-checkbox">
                <label>
                  <input type="checkbox"><span class="label-text">Stay Signed in</span>
                </label>
              </div>
              <p class="semibold-text mb-2"><a href="#" data-toggle="flip">Forgot Password ?</a></p>
            </div>
          </div>-->
          <div class="form-group btn-container">
            <button class="btn btn-primary btn-block"><i class="fa fa-sign-in fa-lg fa-fw"></i>Login</button>
          </div>
        </form>
        <form class="forget-form" action="index.html">
          <h3 class="login-head"><i class="fa fa-lg fa-fw fa-lock"></i>Forgot Password ?</h3>
          <div class="form-group">
            <label class="control-label">EMAIL</label>
            <input class="form-control" type="text" placeholder="Email">
          </div>
          <div class="form-group btn-container">
            <button class="btn btn-primary btn-block"><i class="fa fa-unlock fa-lg fa-fw"></i>RESET</button>
          </div>
          <div class="form-group mt-3">
            <p class="semibold-text mb-0"><a href="#" data-toggle="flip"><i class="fa fa-angle-left fa-fw"></i> Back to Login</a></p>
          </div>
        </form>
      </div>
    </section>
    <!-- Essential javascripts for application to work-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="js/plugins/pace.min.js"></script>
    <script type="text/javascript">
      // Login Page Flipbox control
      $('.login-content [data-toggle="flip"]').click(function() {
      	$('.login-box').toggleClass('flipped');
      	return false;
      });
    </script>
  </body>
</html>