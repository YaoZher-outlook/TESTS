<template>
  <div class="container home">
    <header>
      <h1>欢迎</h1>
    </header>
    <p>这是首页，占位页面，后续可扩展内容。</p>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
export default defineComponent({ name: 'Home' })
</script>

<style>
.container.home { padding: 30px }
</style>
