<template>
  <div class="container attendance">
    <header>
      <h2>考勤记录 - {{ employee.name }}</h2>
    </header>

    <section class="attendance-top">
      <img :src="employee.avatar || defaultAvatar" alt="头像" class="avatar-sm" />
      <div>
        <h3>{{ employee.name }}</h3>
        <p class="meta">编号: {{ employee.id }} • 职位: {{ employee.position }}</p>
      </div>
    </section>

    <section class="records">
      <div v-for="(rec, idx) in records" :key="idx" class="record">
        <div class="status-boxes">
          <div :class="['box', rec.inStatus]" title="签到状态"></div>
          <div :class="['box', rec.outStatus]" title="签退状态"></div>
        </div>
        <div class="times">
          <div class="time-row">签到: <strong>{{ rec.inTime }}</strong></div>
          <div class="time-row">签退: <strong>{{ rec.outTime }}</strong></div>
        </div>
        <div class="remark">{{ rec.remark }}</div>
      </div>
    </section>

    <footer>
      <button class="btn" @click="back">返回</button>
    </footer>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'

export default defineComponent({
  props: { id: String },
  setup(props) {
    const route = useRoute()
    const router = useRouter()
    const employee = ref<any>({})
    const defaultAvatar = '/data/mcpfp - YaoZher.png'
    const records = ref<any[]>([])

    onMounted(async () => {
      const res = await fetch('/data/employees.json').then(r => r.json())
      const employees = res
      const id = (props.id as any) || (route.params.id as string)
      employee.value = employees.find((e: any) => e.id === id) || {}

      // 预填充 10 天记录示例（从最近到早期）
      records.value = [
        { inStatus: 'green', outStatus: 'green', inTime: '09:02', outTime: '18:10', remark: '正常' },
        { inStatus: 'yellow', outStatus: 'green', inTime: '09:15', outTime: '18:05', remark: '迟到 15 分钟' },
        { inStatus: 'green', outStatus: 'yellow', inTime: '08:58', outTime: '17:40', remark: '早退 20 分钟' },
        { inStatus: 'red', outStatus: 'red', inTime: '-', outTime: '-', remark: '缺勤' },
        { inStatus: 'green', outStatus: 'green', inTime: '09:00', outTime: '18:00', remark: '正常' },
        { inStatus: 'green', outStatus: 'green', inTime: '08:59', outTime: '18:02', remark: '正常' },
        { inStatus: 'yellow', outStatus: 'yellow', inTime: '09:22', outTime: '17:45', remark: '迟到 22 分钟，早退 15 分钟' },
        { inStatus: 'green', outStatus: 'green', inTime: '09:00', outTime: '18:10', remark: '正常' },
        { inStatus: 'green', outStatus: 'green', inTime: '09:05', outTime: '18:00', remark: '正常' },
        { inStatus: 'red', outStatus: 'red', inTime: '-', outTime: '-', remark: '病假' }
      ]
    })

    function back() {
      router.back()
    }

    return { employee, records, defaultAvatar, back }
  }
})
</script>

<style>
.container.attendance { max-width: 820px }
.attendance-top { display:flex; gap:12px; align-items:center; margin-bottom:12px }
.avatar-sm { width:56px; height:56px; border-radius:6px; object-fit:cover }
.records { display:flex; flex-direction:column; gap:10px }
.record { display:flex; align-items:center; gap:12px; padding:10px; border-radius:8px; background:#fff; box-shadow:0 4px 10px rgba(0,0,0,0.04) }
.status-boxes { display:flex; gap:6px }
.box { width:18px; height:18px; border-radius:4px }
.box.green { background:#4caf50 }
.box.yellow { background:#ffb300 }
.box.red { background:#f44336 }
.times { flex:1 }
.time-row { color:#333 }
.remark { width:200px; text-align:right; color:#666 }
</style>
