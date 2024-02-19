<template>
  <div>
    <h2>Inicio de Sesión</h2>
    <form @submit.prevent="login">
      <div>
        <label for="username">Usuario:</label>
        <input type="text" id="username" v-model="username" required />
      </div>
      <div>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Iniciar Sesión</button>

      <div class="frc-captcha" data-sitekey="FCMHO851KQSSP9E3" data-start="auto" :data-callback="myCallBack()"/>
    </form>
    <div v-if="errorMessage" style="color: red">{{ errorMessage }}</div>
    <div v-if="loggedIn" style="color: green">
      ¡Has iniciado sesión con éxito!
    </div>
  </div>
</template>

<script>
import "friendly-challenge/widget";
export default {
  data() {
    return {
      username: "",
      password: "",
      errorMessage: "",
      loggedIn: false,
    };
  },
  methods: {
    myCallBack(solution){
      console.log("Captcha was finished with solution:" +solution);
    },
    login() {
      // Aquí puedes agregar lógica para enviar los datos del formulario al servidor para autenticación
      // En este ejemplo, simplemente comprobamos si los campos no están vacíos
      if (this.username && this.password) {
        // Aquí podrías enviar los datos al servidor para autenticación
        // En un escenario real, puedes usar Axios o Fetch API para hacer una solicitud HTTP
        // Por simplicidad, aquí simplemente simulamos una autenticación exitosa después de 1 segundo
        setTimeout(() => {
          this.loggedIn = true;
        }, 1000);
      } else {
        this.errorMessage = "Por favor ingresa un usuario y una contraseña.";
      }
    },
  },
  mounted() {},
};
</script>

<style></style>
