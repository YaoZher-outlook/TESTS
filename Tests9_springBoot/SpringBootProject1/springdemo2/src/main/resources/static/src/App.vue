<template>
  <div>
    <nav class="topbar">
      <div class="logo" @click="goHome">
        <img src="/data/mcpfp - YaoZher.png" alt="logo" />
      </div>
      <ul class="nav">
        <li @click="goHome">首页</li>
        <li @click="goList">员工管理</li>
      </ul>
    </nav>

    <main>
      <router-view />
    </main>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import { useRouter } from 'vue-router'

export default defineComponent({
  setup() {
    const router = useRouter()
    function goHome() { router.push({ name: 'Home' }) }
    function goList() { router.push({ name: 'List' }) }
    return { goHome, goList }
  }
})
</script>

<style>
.container {
  max-width: 1000px;
  margin: 20px auto;
  padding: 20px;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 6px 18px rgba(0,0,0,0.06);
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial;
}

header h1 {
  margin: 0 0 10px 0;
  font-size: 22px;
}

.toolbar {
  display: flex;
  gap: 10px;
  margin-bottom: 12px;
}

.toolbar input {
  flex: 1;
  padding: 8px 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.toolbar button {
  padding: 8px 14px;
  border: none;
  background: #2f9cf0;
  color: #fff;
  border-radius: 4px;
  cursor: pointer;
}

.table-wrap {
  overflow-x: auto;
}

.employee-table {
  width: 100%;
  border-collapse: collapse;
}

.employee-table th,
.employee-table td {
  padding: 10px 12px;
  border-bottom: 1px solid #eee;
  text-align: left;
}

.employee-table thead th {
  background: #f7f9fc;
  font-weight: 600;
}

.employee-table tr.hover {
  background: #f0f8ff;
}

.btn {
  padding: 6px 10px;
  border-radius: 4px;
  border: none;
  cursor: pointer;
  margin-right: 6px;
}

.btn.edit {
  background: #ffd54f;
}

.btn.delete {
  background: #ff7b7b;
}

.btn:hover {
  transform: translateY(-2px);
}

footer {
  margin-top: 16px;
  color: #888;
}

.topbar { display:flex; align-items:center; gap:20px; padding:10px 20px; background:#fff; box-shadow:0 6px 18px rgba(0,0,0,0.04) }
.logo img { width:36px; height:36px; border-radius:6px; cursor:pointer }
.nav { list-style:none; display:flex; gap:18px; margin:0; padding:0 }
.nav li { cursor:pointer; padding:6px 8px; border-radius:6px }
.nav li:hover { background:#f0f8ff }
main { padding:20px }
</style>
