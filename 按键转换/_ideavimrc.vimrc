" insert 换。
set keep-english-in-normal-and-restore-in-insert
set nowrapscan " 禁止在搜索到文件两端时重新搜索
set hlsearch " 搜索时显示高亮
set incsearch
set ignorecase
set smartcase
set showmode
set number " 显示行号
set relativenumber " 相对行号
set scrolloff=3 " 你在写时 始终有三行的位置，不会到最低和最顶
set history=100000
set clipboard+=unnamed "与系统共享剪切板

nnoremap <C-a> ggVG
" split分屏
nnoremap <Space>ws <C-W>s
nnoremap <Space>wv <C-W>v
" 移动到窗口  ##
nnoremap <Space>wj <C-W>j
nnoremap <Space>wk <C-W>k
nnoremap <Space>wh <C-W>h
nnoremap <Space>wl <C-W>l
" <c-f> <c-b> 可用idea alt+ 上下光标
nnoremap <Leader>f <C-f>
nnoremap <Leader>b <C-b>
nnoremap <Leader>d <C-d>
nnoremap <Leader>u <C-u>
" 恢复上一次操作
nnoremap U <C-r>
" 从那里复制到行尾。
nnoremap Y y$





" ==================================================
" 通过`：actionlist`显示所有提供的操作 4
" 直接在idea 里面映射好了，看到效果了，在写在这里来。
" nnoremap(普通模式)
" vnoremap(可视模式)
" inoremap(插入模式)，
" cnoremap(命令行模式)
" onoremap(等待模式)
" 四个方向加alt， alt+j = alt+i
" ==================================================

" Ctrl+Shift+M 在 {} 切换
nnoremap z[ :action EditorMatchBrace<CR>


" 选项卡操作
nnoremap tn gt
nnoremap tp gT




" 实现接口与重写方法。
nnoremap <Leader>i :action ImplementMethods<CR>
nnoremap <Leader>o :action OverrideMethods<CR>
" <A-J> 在按+
nnoremap <Leader>j :action SelectNextOccurrence<CR>
" <A-S-J> 在按-
nnoremap <Leader>jk :action UnselectPreviousOccurrence<CR>

" <C-S-F10>   加Space(空格)
nnoremap <Space>cr :action RunClass<CR>
" <S-F9>
nnoremap <Space>dr :action Debug<CR>
" <C-F5>
nnoremap <Space>r :action Rerun<CR>
" <C-S-CR>
nnoremap [ :action EditorCompleteStatement<CR>a
" <A-Up> alt+ 上下光标
nnoremap <Space>k :action MethodUp<CR>
" <A-Down>
nnoremap <Space>j :action MethodDown<CR>
" <C-S-F12> 全屏
nnoremap <Space>f :action HideAllWindows<CR>



" <C-F12>
vnoremap m :action FileStructurePopup<CR>
" <C-S-Del> ,删除 if 循环 () {} 里面的东东。
vnoremap D :action Unwrap<CR>
" <A-Ins>
vnoremap ai :action Generate<CR>
" <A-Home>
vnoremap ah :action ShowNavBar<CR>
" <F12> 返回上一个窗口。
vnoremap ; :action JumpToLastWindow<CR>

" Ctrl+Alt+F12 在文件夹中显示
vnoremap fb :action ShowFilePath<CR>

" 重构提取变量那些没有了
" 不能右键打开菜单。
" 触发鼠标右键。直接按 show Context Menu,没有显示历史
" 不能停止 <C-F2>
" 折叠






" <F2>
" vnoremap n :action GotoNextError<CR>
" <S-F2>
" vnoremap sp :action GotoPreviousError<CR>
" <C-F1>
" vnoremap d :action ShowErrorDescription<CR>
" alt+v 切换全屏。
" vnoremap cv :action ChangeView<CR>
" <F9>
" vnoremap cd :action ChooseDebugConfiguration<CR>
" <A-C-S-T>
" vnoremap T :action Refactorings.QuickListPopupAction<CR>
" ctrl + r
" nnoremap <Leader>r :action Replace<CR>
" ctrl + f
" nnoremap <Leader>f :action Find<CR>
" <C-H>
" nnoremap <Leader>ch :action TypeHierarchy<CR>
" <C-U>
" nnoremap <Leader>u :action GotoSuperMethod<CR>
" ctrl + w
" nnoremap <Leader>w :action EditorSelectWord<CR>
" <C-N>
" nnoremap <Leader>n :action GotoClass<CR>
" <C-T>
" nnoremap <Leader>t :action Vcs.UpdateProject<CR>
" <C-P>
" nnoremap <Leader>p :action ParameterInfo<CR>
" <C-Q>
" nnoremap <Leader>q :action QuickJavaDoc<CR>
" ctrl + e
" nnoremap <Leader>e :action RecentFiles<CR>
" <C-C>
" nnoremap Y :action $Copy<CR>
" <C-V>
" nnoremap <Space>v :action $Paste<CR>
" <C-S-V>
" nnoremap <Space>av :action PasteMultiple<CR>
" 取消高亮 加Space(空格)
" nnoremap <Space>sc :nohlsearch<CR>
" 写入(保存) ##
" nnoremap <Space>fs :w<CR>
" 退出正常模式  ##
" nnoremap <Space>q  :q<CR>
" nnoremap <Space>Q  :qa!<CR>
" 退出visual模式
" vnoremap v <Esc>
" 插入模式快捷键
" inoremap <C-h> <Left>
" inoremap <C-j> <Down>
" inoremap <C-k> <Up>
" inoremap <C-l> <Right>
" inoremap <C-a> <Home>
" inoremap <C-e> <End>
" inoremap <C-d> <Delete>
" 退出插入模式  ##
" inoremap jj <Esc>
" inoremap jk <Esc>
" inoremap kk <Esc>
" 移到队伍的开始  ##
" nnoremap H ^
" 移动到行尾  ##
" nnoremap L $
" 窗口的操作  ##
" nnoremap <Space>ww <C-W>w
" 全部关闭。 ##
" nnoremap <Space>wd <C-W>c
" split分屏。 ##
" nnoremap <Space>w- <C-W>s
" nnoremap <Space>w\| <C-W>v
" ==================================================
" 通过`：actionlist`显示所有提供的操作
" ==================================================
" <C-G>
" nnoremap <Leader>g :action GotoLine<CR>
" 但保留ideavim搜索 是 \/
" nnoremap <Leader>/ /
" <S-F1> 打开外部文档
" nnoremap <Leader>sf :action ExternalJavaDoc<CR>
" 逐行注释  ##
" nnoremap <Leader>;; :action CommentByLineComment<CR>
" 切换线断点
" nnoremap <Leader>bb :action ToggleLineBreakpoint<CR>
" 查看断点
" nnoremap <Leader>br :action ViewBreakpoints<CR>
" ctrl+shift+a
" nnoremap ga :action GotoAction<CR>
" ctrl+shift+n
" nnoremap gf :action GotoFile<CR>
" 转到实现
" nnoremap gi :action GotoImplementation<CR>
" ctrl+shift+a
" nnoremap gs :action GotoSymbol<CR>
"
" nnoremap <Leader>ga :action GotoAction<CR>
"
" nnoremap <Leader>gc :action GotoClass<CR>
" nnoremap <Leader>gf :action GotoFile<CR>
"
" nnoremap <Leader>gi :action GotoImplementation<CR>
"
" nnoremap <Leader>gs :action GotoSymbol<CR>
"
" nnoremap <Leader>gt :action GotoTest<CR>
" 移动半页更快
" nnoremap <Space>d  <C-d>
" nnoremap <Space>u  <C-u>
" nnoremap <Space>f  <C-u>
" nnoremap <Space>b  <C-u>
" 检查代码
" nnoremap <Leader>ic :action InspectCode<CR>
" 激活Maven项目工具窗口
" nnoremap <Leader>mv :action ActivateMavenProjectsToolWindow<CR>
" 优化进口
" nnoremap <Leader>oi :action OptimizeImports<CR>
" 显示民粹菜单
" nnoremap <Leader>pm :action ShowPopupMenu<CR>
" 运行到光标
" nnoremap <Leader>rc :action RunToCursor<CR>
" 选择运行配置
" nnoremap <Leader>rC :action ChooseRunConfiguration<CR>
" 重命名元素
" nnoremap <Leader>re :action RenameElement<CR>
" 重命名文件
" nnoremap <Leader>rf :action RenameFile<CR>
" 重新运行
" nnoremap <Leader>rr :action Rerun<CR>
" 到处寻找
" nnoremap <Leader>se :action SearchEverywhere<CR>
" 显示用法
" nnoremap <Leader>su :action ShowUsages<CR>
" 关闭活动选项卡
" nnoremap <Leader>tc :action CloseActiveTab<CR>
" 进入
" nnoremap <Leader>si :action StepInto<CR>
" 切换线断点
" nnoremap <Leader>tb :action ToggleLineBreakpoint<CR>
" 激活终端工具窗口
" nnoremap <Leader>tl Vy<CR>:action ActivateTerminalToolWindow<CR>
" 转换激活终端工具窗口
" vnoremap <Leader>tl y<CR>:action ActivateTerminalToolWindow<CR>
" <F5>
" nnoremap <Space>p :action CopyElement<CR>
" <F6>
" nnoremap <Space>p :action Move<CR>
" <A-S-J> -
" nnoremap <Space>asj :action UnselectPreviousOccurrence<CR>
" <A-S-J> all
" nnoremap <Space>casj :action SelectAllOccurrences<CR>
" <C-B> == <C-]>
" nnoremap <Leader>b :action GotoDeclaration<CR>
" nnoremap ;ee :action ToggleChangedOnlyFiles<CR>
" 之前插入的位置 ctrl+i/o
" nnoremap g; :action Back<CR>
" nnoremap g, :action Forward<CR>
" ctrl+ 上下光标 移动时，光标不会动，ctrl+m 又回到那一行上。
" nnoremap zk :action EditorScrollUp<CR>
" nnoremap zj :action EditorScrollDown<CR>
" <C-Tab><C-E>
" nnoremap <Space>e :action Switcher<CR>