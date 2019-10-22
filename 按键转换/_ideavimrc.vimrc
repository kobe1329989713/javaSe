

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
set history=10
set clipboard+=unnamed "与系统共享剪切板



" 恢复上一次操作
nnoremap U <C-r>
" 从那里复制到行尾。
nnoremap Y y$






" ============= l 开关组成命令 =============
" split分屏   s==一，v==|
nnoremap ls <C-W>s  
nnoremap lv <C-W>v
" 移动到窗口  ##
nnoremap lj <C-W>j
nnoremap lk <C-W>k
nnoremap lh <C-W>h
nnoremap tl <C-W>l
" 向下
nnoremap lf <C-f>
nnoremap lb <C-b>
nnoremap ld <C-d>
nnoremap lu <C-u>


" <C-S-F12> 全屏
nnoremap la :action HideAllWindows<CR>
" <F12> 返回上一个窗口。
nnoremap lc :action JumpToLastWindow<CR>

" <A-Up> alt+ 上下光标 下
nnoremap ln :action MethodDown<CR>
" <A-Up> alt+ 上下光标 上
nnoremap lN :action MethodUp<CR>

" <F2>
nnoremap lo :action GotoNextError<CR>
" <S-F2>
nnoremap lO :action GotoPreviousError<CR>
" <C-F1>
nnoremap lp :action ShowErrorDescription<CR>

" <C-E> <C-Tab>要多按下 <CR>==回车
nnoremap K :action RecentFiles<CR>
" <C-S-E>
nnoremap l; :action RecentLocations<CR>
" <C-S-V>
nnoremap lg :action PasteMultiple<CR>

" <C-S-BS> gi  它不进行插入模式，退格是 BS
" 上次编辑的位置，ideavim 有 :changes 说明支持 g; g, 命令了。
nnoremap li :action JumpToLastChange<CR>



" === m
" <C-F12>
nnoremap lm :action FileStructurePopup<CR>


" === e
" <A-Ins>
nnoremap le :action Generate<CR>

" === r
" <A-C-L>格式化代码
nnoremap lr :action ReformatCode<CR>
" <C-A-O>
nnoremap lR :action OptimizeImports<CR>

" === t
" <C-S-Del> ,删除 if 循环 () {} 里面的东东。
nnoremap lt :action Unwrap<CR>
" Ctrl+Alt+F12 在文件夹中显示
nnoremap lT :action ShowFilePath<CR>

" === w
" <C-S-i>
nnoremap lw :action QuickImplementations<CR>

" === y
" <F9>
nnoremap ly :action ChooseDebugConfiguration<CR>

" === x
" 折叠之全部斩开
nnoremap lx :action ExpandAllRegions<CR>

" === z
" === q



" ============= 空格 ============= c d  Z
" <C-S-F10>   加Space(空格)
nnoremap <Space>cr :action RunClass<CR>
" <S-F9>
nnoremap <Space>dr :action Debug<CR>
" <C-S-CR>
nnoremap [ :action EditorCompleteStatement<CR>a

"===> a
" <C-F5>
nnoremap <Space>a :action Rerun<CR>
" 停止<C-F2>  
nnoremap <Space>A :action Stop<CR>

"===> b
" <C-F8>打上断点 / 取消断点  
nnoremap <Space>b :action ToggleLineBreakpoint<CR>
" <A-C-S-F8>临时断点，运行完自动删除断点
nnoremap <Space>B :action ToggleTemporaryLineBreakpoint<CR>

"===> e
" <C-S-F8> 取消所有(某些)断点和查看断点
nnoremap <Space>e :action ViewBreakpoints<CR>

"===> f
" 禁用断点(运行debug时有效)
nnoremap <Space>f :action XDebugger.MuteBreakpoints<CR>

"===> g
" <A-F10> 回到断点(无论在那里都回到执行那一步断点)
nnoremap <Space>g :action ShowExecutionPoint<CR>

"===> h
" F7 进入方法里
nnoremap <Space>h :action StepInto<CR>
" <A-S-F7> 强力进入某个方法里
nnoremap <Space>H :action ForceStepInto<CR>
"===> o
" <S-F7> tab 进入到某个特定的方法里。
nnoremap <Space>o :action SmartStepInto<CR>

"===> i
" <S-F8> 从某个方法里退出
nnoremap <Space>i :action StepOut<CR>

"===> j
" F8
nnoremap <Space>j :action StepOver<CR>

"===> k
" <A-F8>计算表达式，选中它，在按
nnoremap <Space>k :action EvaluateExpression<CR>

"===> l
" <A-F9>执行到光标所在行
nnoremap <Space>l :action RunToCursor<CR>

"===> m
" <F9> 执行到下一个断点。 
nnoremap <Space>m :action Resume<CR>

"===> n
" <C-S-F8> 编辑断点 
nnoremap <Space>n :action EditBreakpoint<CR>

"===> q
"===> s
"===> p
"===> r
"===> t
"===> u
"===> v
"===> w
"===> x
"===> y
"===> z


" 重新运行断点(降针) Drop Frame





" ============= \ ============= f d u b Z
"===> a
" 关闭所有标签页。
nnoremap <Leader>a :action CloseAllEditors<CR>
"===> e
" 关闭其它标签页。
nnoremap <Leader>e :action CloseAllEditorsButActive<CR>
" <C-S-A-T> 打开重构窗口
nnoremap <Leader>E :action Refactorings.QuickListPopupAction<CR>
"===> w
" <C-F4> 关闭当前标签页。
nnoremap <Leader>w :action CloseContent<CR>


" 退出
nnoremap zq :action Exit<CR>
"===> c
" <A-C-F7>,<A-F7> 在那些地方用到它了。
" <A-C-F7>
nnoremap <Leader>c :action ShowUsages<CR>
" <A-F7>
nnoremap <Leader>C :action FindUsages<CR>


"===> h
" Ctrl+Shift+M 在 {} 切换
nnoremap <Leader>h :action EditorMatchBrace<CR>
"===> i
" 实现接口
nnoremap <Leader>i :action ImplementMethods<CR>
"===> o
" 重写方法。
nnoremap <Leader>o :action OverrideMethods<CR>


"===> j
" <A-7>
nnoremap <Leader>j :action ActivateStructureToolWindow<CR>
"===> k  光标最好在那个类上。
" <A-C-U>
nnoremap <Leader>k :action ShowUmlDiagramPopup<CR>
" <A-C-S-U>
nnoremap <Leader>K :action ShowUmlDiagram<CR>



"===> t
" <A-C-T> 环绕 if
nnoremap <Leader>T :action SurroundWith<CR>
" <C-F7>
nnoremap <Leader>t :action FindUsagesInFile<CR>


"===> y
" <C-F9> 编译整个项目
nnoremap <Leader>y :action CompileDirty<CR>
" <C-S-F9> 编译所在的这个文件
nnoremap <Leader>Y :action Compile<CR>
"===> q
" 转换激活终端工具窗口
nnoremap <Leader>q :action ActivateTerminalToolWindow<CR>

"===> z
" <A-Q>
nnoremap <Leader>z :action EditorContextInfo<CR>
"===> p
nnoremap <Leader>p :action ShowNavBar<CR>



"===> x
"===> l
"===> g
"===> n
"===> r
"===> s
"===> v
"===> m



" ============= g =============
" <A-C-Left> 上一次编辑地方
nnoremap g; :action Back<CR>
" <A-C-Right> 下一次编辑地方
nnoremap g, :action Forward<CR>

" === a
" === b
" === c
" === d
" === e
" === f
" === g
" === h
" === i
" === j
" === k
" === l
" === m
" === n
" === o
" === p
" === q
" === r
" === s
" === t
" === u
" === v
" === w
" === x
" === y
" === z


" ============= t 开关组成命令 ============= l
" 选项卡操作
nnoremap tn gt
nnoremap tp gT

" === a
" === b
" === c
" === d
" === e
" === f
" === g
" === h
" === i
" === j
" === k
" === l
" === m
" === o
" === q
" === r
" === s
" === t
" === u
" === v
" === w
" === x
" === y
" === z

" ============= z 开关组成命令 =============

" === a
" === b
" === c
" === d
" === e
" === f
" === g
" === h
" === i
" === j
" === k
" === l
" === m
" === n
" === o
" === p
" === q
" === r
" === s
" === t
" === u
" === v
" === w
" === x
" === y
" === z