<template>
  <div>
    <div class="container">
      <header>
        <h1>公司员工管理系统</h1>
      </header>

      <section class="toolbar">
        <input v-model="search" placeholder="搜索姓名或职位..." />
        <button @click="addDummy">新增员工</button>
      </section>

      <section class="table-wrap">
        <table class="employee-table">
          <thead>
            <tr>
              <th>编号</th>
              <th>姓名</th>
              <th>性别</th>
              <th>入职时间</th>
              <th>职位</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(emp, idx) in filteredEmployees" :key="emp.id" @mouseover="hover = emp.id" @mouseleave="hover = null" :class="{ hover: hover === emp.id }">
              <td>{{ emp.id }}</td>
              <td>{{ emp.name }}</td>
              <td>{{ emp.gender }}</td>
              <td>{{ emp.hireDate }}</td>
              <td>{{ emp.position }}</td>
              <td>
                <button class="btn edit" @click="editEmployee(emp)">编辑</button>
                <button class="btn delete" @click="deleteEmployee(emp.id)">删除</button>
              </td>
            </tr>
          </tbody>
        </table>
      </section>

      <footer>
        <small>预留字段用于未来功能扩展。</small>
      </footer>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, computed, onMounted } from 'vue'
import { useRouter } from 'vue-router'

export default defineComponent({
  setup() {
    const search = ref('')
    const hover = ref<string | null>(null)
    const employees = ref<any[]>([])
    const router = useRouter()

    onMounted(async () => {
      try {
        const res = await fetch('/list')
        employees.value = await res.json()
      } catch (e) {
        console.error('fetch /list failed', e)
        employees.value = []
      }
    })

    const filteredEmployees = computed(() => {
      const q = search.value.trim().toLowerCase()
      if (!q) return employees.value
      return employees.value.filter((e: any) => {
        const name = (e.name || '').toString().toLowerCase()
        const pos = (e.position || '').toString().toLowerCase()
        const id = (e.id || '').toString().toLowerCase()
        return name.includes(q) || pos.includes(q) || id.includes(q)
      })
    })

    function editEmployee(emp: any) {
      router.push({ name: 'Profile', params: { id: emp.id } })
    }

    function deleteEmployee(id: string) {
      if (!confirm(`确定要删除员工 ${id} 吗？`)) return
      const idx = employees.value.findIndex(e => e.id === id)
      if (idx !== -1) employees.value.splice(idx, 1)
    }

    function addDummy() {
      const nextId = `E${String(employees.value.length + 1).padStart(3, '0')}`
      employees.value.push({ id: nextId, name: '新员工', gender: '男', hireDate: new Date().toISOString().slice(0,10), position: '待定' })
    }

    function goHome() { router.push({ name: 'Home' }) }
    function goList() { router.push({ name: 'List' }) }

    return { search, hover, employees, filteredEmployees, editEmployee, deleteEmployee, addDummy, goHome, goList }
  }
})
</script>
