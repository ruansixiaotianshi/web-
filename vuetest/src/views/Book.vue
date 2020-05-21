<template>
    <div>
        <table>
            <tr>
                <td>编号</td>
                <td>图书名称</td>
                <td>作者</td>
            </tr>
        </table>
       <tr v-for="item in books">
           <td>{{item.id}}}</td>
           <td>{{item.name}}}</td>
           <td>{{item.author}}}</td>

       </tr>
    </div>
</template>

<script>
    export default {
        name: "Book",
        data(){
            return {
                msg: 'Hello Vue',
                books: [
                    {
                        id: 1,
                        name: '数据结构',
                        author: '王泽雅'
                    },

                    {
                        id: 2,
                        name: '数据库',
                        author: '黄泽华'
                    },
                    {
                        id: 3,
                        name: 'Spring Boot',
                        author: '张三'
                    }

                ]
            }
        },
        created() {
            alert(123)
        }
    }
</script>

<style scoped>

</style>