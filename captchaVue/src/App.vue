<template>
  <form @submit.prevent="submitForm">
    <label for="name"> Nombre:</label><br />
    <input type="text" id="name" 
    v-model="formData.name" required />
    <br/><br/>

    <div
      ref="container"
      class="frc-captcha"
      data-sitekey="FCMHO851KOUGPVCM"
      data-lang="es"
    ></div>

    <!-- Botón de envío -->
    <button type="submit">Enviar</button>
  </form>
</template>


<script>
import { WidgetInstance } from "friendly-challenge";

import { ref } from "vue";

import CaptchaService from '../src/services/captchaService';

export default {
  data() {
    return {
      container: ref(),
      widget: ref(),
      formData: {
        name: ""
      },
    };
  },

  methods: {
    //No comunicamos hacia
    //el back de nuestra aplicación.
    
    submitForm() {},
    
    async verifyCaptcha(solution) {
      let response = await CaptchaService.verificarCaptcha(solution);
      console.log(response);
    },
    doneCallback(solution) {
      this.verifyCaptcha(solution);
    },

    errorCallback: (err) => {
      console.log("There was an error when trying to solve the Captcha.");
      console.log(err);
    },
  },

  mounted() {
    if (this.$refs.container) {
      this.widget = new WidgetInstance(
        this.$refs.container, {
          startMode: "",
          doneCallback: this.doneCallback,
          errorCallback: this.errorCallback,
        }
      );
    }
  },

  beforeDestroy() {
    if (this.widget) {
      this.widget.destroy();
    }
  },
};
</script>

<style></style>
