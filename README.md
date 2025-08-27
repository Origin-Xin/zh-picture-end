# 企业级智能协同云图库平台

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Vue](https://img.shields.io/badge/Vue-3.3-green.svg)](https://vuejs.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-green.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)

基于 Vue 3 + Spring Boot + COS + WebSocket 构建的企业级智能协同云图库平台，集图片存储、管理、检索、协同编辑于一体。

## ✨ 核心功能

### 🌐 多场景应用
- **公开图库**: 所有用户都可以在平台公开上传和检索图片素材，快速找到需要的图片。可用作表情包网站、设计素材网站、壁纸网站等
- **管理员系统**: 管理员可以上传、审核和管理图片，并对系统内的图片进行分析
- **个人空间**: 可将图片上传至私有空间进行批量管理、检索、编辑和分析，用作个人网盘、个人相册、作品集等
- **团队协作**: 企业可开通团队空间并邀请成员，共享图片并实时协同编辑图片，提高团队协作效率。可用于企业活动相册、企业内部素材库等

## 🛠️ 技术架构

### 后端技术栈
- **核心框架**: Java Spring Boot
- **数据库**: MySQL + MyBatis-Plus + MyBatis X
- **缓存系统**: Redis 分布式缓存 + Caffeine 本地缓存
- **数据采集**: Jsoup 数据抓取
- **文件存储**: ⭐️ COS 对象存储
- **数据分片**: ⭐️ ShardingSphere 分库分表
- **权限控制**: ⭐️ Sa-Token 权限控制
- **架构设计**: ⭐️ DDD 领域驱动设计
- **实时通信**: ⭐️ WebSocket 双向通信
- **高性能队列**: ⭐️ Disruptor 高性能无锁队列
- **并发处理**: ⭐️ JUC 并发和异步编程
- **智能处理**: ⭐️ AI 绘图大模型接入
- **代码质量**: ⭐️ 多种设计模式的运用
- **系统优化**: ⭐️ 多角度项目优化：性能、成本、安全性等

### 前端技术栈
- **核心框架**: Vue 3
- **构建工具**: Vite
- **UI组件**: Ant Design Vue
- **HTTP客户端**: Axios
- **状态管理**: Pinia
- **工程化**: ⭐️ ESLint + Prettier + TypeScript
- **API集成**: ⭐️ OpenAPI 前端代码生成

## 🚀 快速开始

### 环境要求
- JDK 17+
- Node.js 18+
- MySQL 8.0+
- Redis 7.0+
- Maven 3.6+

### 后端部署

1. **数据库初始化**
```bash
mysql -u root -p < database/init.sql
```

配置文件设置
```bash
cp application-example.yml application.yml
# 修改数据库、Redis、COS等配置
```

启动服务
```bash
mvn clean install
mvn spring-boot:run
```
前端部署

安装依赖

```bash
npm install
```
环境配置
```bash
cp .env.example .env
# 配置API地址和其他环境变量
```
启动开发服务器
```bash
npm run dev
```

📖 使用指南
基本操作
用户注册/登录: 支持邮箱注册和第三方登录

图片上传: 拖拽上传、批量上传、断点续传

图片管理: 相册分类、标签管理、权限设置

图片检索: 智能搜索、条件筛选、相似图片推荐

高级功能

团队协作:
- 创建团队空间
- 邀请成员加入 
- 设置成员权限 
- 实时协同编辑

AI智能功能:
- 自动标签生成 
- 内容识别分类 
- 智能裁剪优化 
- 相似图片去重

数据分析:
- 存储空间统计 
- 访问热度分析 
- 用户行为分析 
- 系统性能监控

🏗️ 项目结构
```text
├── backend/                 # 后端项目
│   ├── src/main/java/
│   │   ├── controller/     # 控制器层
│   │   ├── service/        # 服务层
│   │   ├── repository/     # 数据访问层
│   │   ├── model/          # 数据模型
│   │   ├── config/         # 配置类
│   │   └── util/           # 工具类
│   └── resources/
│       └── application.yml # 配置文件
├── frontend/               # 前端项目
│   ├── src/
│   │   ├── api/           # API接口
│   │   ├── components/    # 组件
│   │   ├── views/         # 页面
│   │   └── stores/        # 状态管理
│   └── package.json
└── database/              # 数据库脚本
```

🤝 贡献指南
我们欢迎任何形式的贡献！请按以下步骤参与项目：

Fork 本仓库

创建特性分支: git checkout -b feature/新功能

提交更改: git commit -m '添加新功能'

推送到分支: git push origin feature/新功能

提交 Pull Request

📝 更新日志
详细更新内容请查看 CHANGELOG.md 文件。

🛡️ 许可证
本项目采用 MIT 许可证 - 详见 LICENSE 文件。

📞 联系方式
项目地址: GitHub Repository

问题反馈: Issues

邮箱: your-email@example.com

🙏 致谢
感谢以下技术和服务的支持：

Vue.js 和 Spring Boot 开发团队

腾讯云 COS 对象存储服务

所有贡献者和用户

⭐ 如果这个项目对您有帮助，请给我们一个 star！
