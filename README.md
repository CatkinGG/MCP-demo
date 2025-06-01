# MCP-demo

## Figma MCP 可用工具

1. **取得 Figma 檔案資料**  
   可根據 Figma 檔案 key 取得整份設計稿的結構與節點資訊。
   - 典型 API：`get_figma_data(fileKey, nodeId, depth)`

2. **下載 Figma 圖片資源**  
   可根據節點 ID 批次下載設計稿中的 SVG 或 PNG 圖片。
   - 典型 API：`download_figma_images(fileKey, nodes, scale, localPath)`

3. **取得 Figma 節點資訊**  
   可針對特定 nodeId 取得詳細的節點屬性與樣式。
   - 典型 API：`get_figma_data(fileKey, nodeId)`

4. **同步設計稿與程式碼**  
   可將 Figma 設計稿內容同步到本地專案，協助設計與開發協作。
