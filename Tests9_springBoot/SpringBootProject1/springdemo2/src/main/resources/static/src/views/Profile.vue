<template>
  <div class="container profile">
    <header>
      <h2>员工主页</h2>
    </header>

    <section class="profile-top">
      <div class="avatar">
        <img :src="employee.avatar || defaultAvatar" alt="头像" />
      </div>

      <div class="profile-summary">
        <template v-if="!isEditing">
          <h3>
            {{ employee.name }}
            <span class="status-pill" :class="pillClass">
              <span class="status-text">{{ employee.status }}</span>
              <span class="status-dot" :class="dotClass"></span>
            </span>
          </h3>
          <p class="meta">编号: {{ employee.id }} • 职位: {{ employee.position }}</p>
          <p class="meta">入职时间: {{ employee.hireDate }}</p>
        </template>

        <template v-else>
          <input v-model="form.name" class="input-name" />
          <p class="meta">编号: {{ employee.id }} • <input v-model="form.position" class="input-inline" /></p>
          <p class="meta">入职时间: <input v-model="form.hireDate" type="date" class="input-inline" /></p>
        </template>
      </div>
    </section>

    <section class="profile-details">
      <table>
        <tbody>
          <tr>
            <th>编号</th>
            <td>{{ employee.id }}</td>
          </tr>

          <tr>
            <th>姓名</th>
            <td v-if="!isEditing">{{ employee.name }}</td>
            <td v-else><input v-model="form.name" /></td>
          </tr>

          <tr>
            <th>性别</th>
            <td v-if="!isEditing">{{ employee.gender }}</td>
            <td v-else>
              <select v-model="form.gender">
                <option>男</option>
                <option>女</option>
                <option>其他</option>
              </select>
            </td>
          </tr>

          <tr>
            <th>入职时间</th>
            <td v-if="!isEditing">{{ employee.hireDate }}</td>
            <td v-else><input v-model="form.hireDate" type="date" /></td>
          </tr>

          <tr>
            <th>职位</th>
            <td v-if="!isEditing">{{ employee.position }}</td>
            <td v-else><input v-model="form.position" /></td>
          </tr>

          <tr>
            <th>联系电话</th>
            <td v-if="!isEditing">{{ employee.phone || '无' }}</td>
            <td v-else><input v-model="form.phone" /></td>
          </tr>
        </tbody>
      </table>

      <div class="actions">
        <template v-if="!isEditing">
          <button @click="viewAttendance" class="btn">查看考勤记录</button>
          <button @click="startEdit" class="btn edit">更改个人信息</button>
          <button @click="copyPhone" class="btn">复制电话号码</button>
        </template>

        <template v-else>
          <button @click="saveChanges" class="btn">保存</button>
          <button @click="cancelEdit" class="btn edit">取消</button>
        </template>
      </div>
    </section>

    <footer>
      <small>与管理系统风格统一，数据来源于前端静态数据（可替换为后端接口）。</small>
    </footer>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, onMounted, reactive, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'

export default defineComponent({
  props: { id: String },
  setup(props) {
    const route = useRoute()
    const router = useRouter()
    const employees = ref<any[]>([])
    const employee = ref<any>({})
    const defaultAvatar = '/data/mcpfp - YaoZher.png'

    const isEditing = ref(false)
    const form = reactive({ id: '', name: '', gender: '', hireDate: '', position: '', phone: '', avatar: '', status: '' })

    onMounted(async () => {
      const res = await fetch('/data/employees.json').then(r => r.json())
      employees.value = res
      const id = (props.id as any) || (route.params.id as string)
      employee.value = employees.value.find(e => e.id === id) || {}
    })

    function startEdit() {
      // 进入编辑并将当前数据拷贝到表单
      Object.assign(form, employee.value)
      isEditing.value = true
    }

    function cancelEdit() {
      isEditing.value = false
    }

    async function saveChanges() {
      // 模拟提交到后端（实际替换为真实接口）
      try {
        const payload = { ...form }
        // 发送到后端（示例）
        await fetch(`/api/employees/${payload.id}`, {
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(payload)
        })
      } catch (e) {
        // 忽略网络错误：仍然在前端应用更改
      }
      // 将更改应用到本地展示数据
      employee.value = { ...form }
      // 更新本地 employees 数据（前端数据源）
      const idx = employees.value.findIndex((e: any) => e.id === employee.value.id)
      if (idx !== -1) employees.value.splice(idx, 1, { ...employee.value })

      isEditing.value = false
      alert('已保存（示例，若连接后端请确保后端接口已实现）')
    }

    function viewAttendance() {
      // 跳转到考勤页面，传递员工 id
      const id = employee.value.id
      router.push({ name: 'Attendance', params: { id } })
    }

    function copyPhone() {
      const phone = employee.value.phone || '无联系电话'
      navigator.clipboard?.writeText(phone)
      alert(`已复制: ${phone}`)
    }

    const dotClass = computed(() => {
      const status = (isEditing.value ? form.status : employee.value.status) || ''
      if (status.includes('公司')) return 'dot-green'
      if (status.includes('休假')) return 'dot-yellow'
      if (status.includes('缺勤')) return 'dot-red'
      return 'dot-gray'
    })

    const pillClass = computed(() => (isEditing.value ? 'editing' : ''))

    return { employee, defaultAvatar, viewAttendance, startEdit, copyPhone, isEditing, form, saveChanges, cancelEdit, dotClass, pillClass }
  }
})
</script>

<style>
.container.profile { max-width: 760px }
.profile-top { display:flex; gap:20px; align-items:center }
.avatar { position: relative }

/* 状态长条（凹陷效果） */
.status-pill {
  display:inline-flex;
  align-items:center;
  gap:8px;
  padding:6px 10px;
  border-radius:20px;
  background: linear-gradient(180deg,#f5f7fa,#e9eef6);
  box-shadow: inset 0 2px 6px rgba(0,0,0,0.06);
  margin-left:12px;
  font-size:13px;
  color:#333;
}
.status-text { display:inline-block }
.status-dot { width:10px; height:10px; border-radius:50%; display:inline-block; margin-left:6px; }
.status-dot.dot-green { background:#4caf50 }
.status-dot.dot-yellow { background:#ffb300 }
.status-dot.dot-red { background:#f44336 }
.status-dot.dot-gray { background:#bbb }

.avatar img { width:120px; height:120px; border-radius:8px; object-fit:cover }
.input-name { font-size:18px; padding:6px 8px; border-radius:6px; border:1px solid #ddd }
.input-inline { padding:4px 6px; border-radius:4px; border:1px solid #ddd }
.profile-summary h3{ margin:0 }
.profile-details table { width:100%; border-collapse: collapse; margin-top:14px }
.profile-details th { text-align:left; width:140px; padding:8px 10px; background:#f7f9fc }
.profile-details td { padding:8px 10px; border-bottom:1px solid #eee }

.actions { margin-top:12px }
.actions .btn { margin-right:8px }
.btn { padding:6px 10px; border-radius:4px; border:none; cursor:pointer }
.btn.edit { background:#ffd54f }

</style>
