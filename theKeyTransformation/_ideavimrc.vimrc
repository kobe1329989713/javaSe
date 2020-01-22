

" source D:\kobe\idea\ideaProjects\space01\javaSE01\theKeyTransformation\_ideavimrc.vimrc
" set keep-english-in-normal-and-restore-in-insert

set nowrapscan " 禁止在搜索到文件两端时重新搜索
set hlsearch " 搜索时显示高亮
set incsearch
set ignorecase
set smartcase
set showmode
set number " 显示行号
set relativenumber " 相对行号
set scrolloff=1 " 你在写时 始终有三行的位置，不会到最低和最顶
set history=10
set clipboard+=unnamed "与系统共享剪切板



" 恢复上一次操作
nnoremap U <C-r>
" 从那里复制到行尾。
nnoremap Y y$





" ============= 空格 ============= hl nz sv 
" <C-S-F10>   加Space(空格)
nnoremap <Space>cr :action RunClass<CR>
" <S-F9>
nnoremap <Space>dr :action Debug<CR>
"===> a
" <C-F5>
nnoremap <Space>a :action Rerun<CR>
" <C-S-CR>
nnoremap [ :action EditorCompleteStatement<CR>a

" 显示右键菜单
nnoremap <Space>t :action ShowPopupMenu


"===> a
" 关闭所有标签页。
nnoremap <Space>A :action CloseAllEditors<CR>

" <F2>
nnoremap <Space>q :action GotoNextError<CR>
" <S-F2>
nnoremap <Space>p :action GotoPreviousError<CR>
" <C-F1>
nnoremap <Space>o :action ShowErrorDescription<CR>

" <C-E> <C-Tab>要多按下 <CR>==回车
nnoremap <Space>x :action RecentFiles<CR>
" <C-S-V>
nnoremap <Space>g :action PasteMultiple<CR>

" <C-S-BS> gi  它不进行插入模式，退格是 BS
" 上次编辑的位置，ideavim 有 :changes 说明支持 g; g, 命令了。
nnoremap <Space>i :action JumpToLastChange<CR>

" === e
" <A-Ins>
nnoremap <Space>e :action Generate<CR>
"===> e
" 关闭其它标签页。
nnoremap <Space>E :action CloseAllEditorsButActive<CR>

" === r
" <A-C-L>格式化代码
nnoremap <Space>r :action ReformatCode<CR>
" <C-A-O>
nnoremap <Space>R :action OptimizeImports<CR>
" <C-S-Del> ,删除 if 循环 () {} 里面的东东。
nnoremap <Space>D :action Unwrap<CR>




" <C-S-i>
nnoremap <Space>w :action QuickImplementations<CR>
"===> w
" <C-F4> 关闭当前标签页。
nnoremap <Space>W :action CloseContent<CR>
" <F9>
nnoremap <Space>y :action ChooseDebugConfiguration<CR>

" <C-F12>
nnoremap <Space>m :action FileStructurePopup<CR>
" <A-Up> alt+ 上下光标 下
nnoremap <Space>j :action MethodDown<CR>
" <A-Up> alt+ 上下光标 上
nnoremap <Space>k :action MethodUp<CR>




" ============= \ ============= 
" <A-C-S-S> 项目设置
nnoremap <Leader>A :action ShowProjectStructureSettings<CR>
" <A-C-S>
nnoremap <Leader>a :action ShowSettings<CR>
" <A-C-S-Ins> 创建临时文件。
nnoremap <Leader>B :action NewScratchFile<CR>
" 显示历史 action LocalHistory.ShowSelectionHistory
nnoremap <Leader>b :action LocalHistory.ShowHistory<CR>
" 折叠之全部斩开
nnoremap <Leader>c :action ExpandAllRegions<CR>

" split分屏 
nnoremap <Leader>s <C-W>s  
nnoremap <Leader>v <C-W>v
" 移动到窗口
nnoremap <Leader>j <C-W>j
nnoremap <Leader>k <C-W>k
nnoremap <Leader>h <C-W>h
nnoremap <Leader>l <C-W>l
" 关闭分屏。
nnoremap <Leader>w <C-W>c

" vim <C-V>
nnoremap <Leader>y <C-v>

" d
" 新建请求 xx.http 请求测试文件。
nnoremap <Leader>D :action HTTP.Request.NewFile<CR>
" 在请求测试文件新增请求。
nnoremap <Leader>d :action HTTPClient.AddRequest<CR>


" e
" f
" g
" i
" m
" n
" o
" p
" q
" r
" t
" u
" x
" z

" ============= Shift =============
" 左右切换页面
nnoremap <S-J> :action PreviousTab<CR>
nnoremap <S-K> :action NextTab<CR>



" ============= g =============
" <A-C-Left> 上一次编辑地方
nnoremap g; :action Back<CR>
" <A-C-Right> 下一次编辑地方
nnoremap g, :action Forward<CR>

" <C-S-A>
nnoremap ga :action GotoAction<CR>


" ============= m =============
" <C-F8>打上断点 / 取消断点  
nnoremap mb :action ToggleLineBreakpoint<CR>
" <A-C-S-F8>临时断点，运行完自动删除断点
nnoremap mB :action ToggleTemporaryLineBreakpoint<CR>


" F8
nnoremap mm :action StepOver<CR>
" <C-S-F8> 取消所有(某些)断点和查看断点
nnoremap me :action ViewBreakpoints<CR>

" <C-S-F8> 编辑断点,加条件
nnoremap mn :action EditBreakpoint<CR>
" F7 进入方法里
nnoremap mh :action StepInto<CR>
" <A-S-F7> 强力进入某个方法里
nnoremap mH :action ForceStepInto<CR>

" <S-F7> tab 进入到某个特定的方法里。
nnoremap mo :action SmartStepInto<CR>

" <S-F8> 从某个方法里退出
nnoremap mi :action StepOut<CR>

" <A-F10> 回到断点(无论在那里都回到执行那一步断点)
nnoremap mg :action ShowExecutionPoint<CR>
" <A-F8>计算表达式，选中它，在按
nnoremap mk :action EvaluateExpression<CR>
" <A-F9>执行到光标所在行
nnoremap ml :action RunToCursor<CR>
" <F9> 执行到下一个断点。 
nnoremap mj :action Resume<CR>
" 禁用断点(运行debug时有效)
nnoremap mf :action XDebugger.MuteBreakpoints<CR>


" 重新运行断点(降针) Drop Frame
nnoremap mx :action Debugger.PopFrame<CR>





" <C-F9> 编译整个项目
nnoremap mp :action CompileDirty<CR>
" <C-S-F9> 编译所在的这个文件
nnoremap mP :action Compile<CR>

" <C-F12>转换激活终端工具窗口
nnoremap mq :action ActivateTerminalToolWindow<CR>

" 与粘贴板进行比较
nnoremap mr :action CompareClipboardWithSelection<CR>

" Ctrl+Alt+F12 在文件夹中显示
nnoremap mS :action ShowFilePath<CR>
" <A-F1>
nnoremap ms :action SelectIn<CR>

" 停止<C-F2>  
nnoremap mt :action Stop<CR>


" <A-W> 翻译
nnoremap ma :action $EditorTranslateAction<CR>
" <A-R> 翻译-->替换
nnoremap mA :action $TranslateAndReplaceAction<CR>
" <C-S-S> 翻译-快速窗口
nnoremap md :action $ShowInstantTranslationDialogAction<CR>
" <C-S-O> 翻译窗口 要回车
nnoremap mD :action $TranslateTextComponent<CR>

" <A-C-U>
nnoremap mc :action ShowUmlDiagramPopup<CR>
" <A-C-S-U>
nnoremap mC :action ShowUmlDiagram<CR>


" <C-S-F12> 全屏,与返回
nnoremap mu :action HideAllWindows<CR>
" <F12> 返回上一个窗口。
nnoremap mv :action JumpToLastWindow<CR>

" <C-S-E>
nnoremap my :action RecentLocations<CR>


" <C-S-M>
nnoremap mz :action EditorMatchBrace<CR>

" ============= q =============
" 向下
nnoremap qf <C-f>
nnoremap qb <C-b>
nnoremap qd <C-d>
nnoremap qu <C-u>
" 行首与行尾
nnoremap qh ^
nnoremap ql $

" 重命名元素
nnoremap qm :action RenameElement<CR>
" 重命名文件
nnoremap qM :action RenameFile<CR>

" ctrl+ 上下光标 移动时，光标不会动，ctrl+m 又回到那一行上。
nnoremap qj :action EditorScrollUp<CR>
nnoremap qk :action EditorScrollDown<CR>
" <C-M>
nnoremap qn :action EditorScrollToCenter<CR>


" <A-C-S-C>复制引用路径
nnoremap qc :action CopyReference<CR>
" <C-S-C>复制在文件夹路径
nnoremap qC :action CopyAbsolutePath<CR>

" ============= z =============



" a
" b
" c
" d
" e
" f
" g
" h
" i
" j
" k
" l
" m
" n
" o
" p
" q
" r
" s
" t
" u
" v
" w
" x
" y
" z

